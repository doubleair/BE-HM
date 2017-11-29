package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;

import Utils.WXUtil;
import common.RPCResult;
import constants.RedisMapKeyConstant;
import constants.RedisPrefixConstant;
import model.AuthTokenModel;
import model.UserCenterModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.HuamingInfoService;
import service.RedisService;
import service.UserCenterService;

/**
 * 用户controller
 * 
 * @author jizhi.qy 2017年11月6日 上午10:32:24
 */
@Controller
public class UserLoginController {

    private static final Log Log = LogFactory.getLog(UserLoginController.class);

    @Resource
    private RedisService redisService;
    @Resource
    private UserCenterService userCenterService;
    @Resource
    private HuamingInfoService huamingInfoService;
    // @Resource
    // private JianghuService jianghuService;

    /**
     * 登录接口，流程：
     * 1. 检验wxSessionCode
     * 2. 向wx服务器获取用户session和openId
     * 3. 生成本服务器的session
     * 4. session信息写入redis
     * 5. 查看该用户是否已经注册，注册过(就更新信息)，没注册过就插入信息
     * 
     * @param wxSessionCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/login")
    public RPCResult login(@RequestParam(value = "wxSessionCode") String wxSessionCode,
        @RequestParam(value = "nickName", required = false) String nickName,
        @RequestParam(value = "city", required = false) String city,
        @RequestParam(value = "province", required = false) String province,
        @RequestParam(value = "country", required = false) String country,
        @RequestParam(value = "avatarUrl", required = false) String avatarUrl,
        @RequestParam(value = "gender", required = false) Integer gender) {
        
        UserCenterModel userCenterModel = null;
        Map<String, String> res = new HashMap<String, String>();
        boolean success = false;

        if (StringUtils.isEmpty(wxSessionCode)) {
            Log.error("code is Empty");
            return RPCResult.error(RPCResult.CODE_PARAM_ERROR, "code is null");
        }

        // 从微信服务器获取用户openId和sessionKey数据
        AuthTokenModel authTokenModel = WXUtil.getAuthToken(wxSessionCode);

        if (null == authTokenModel) {
            return RPCResult.error(RPCResult.CODE_SERVER_ERROR, "wx request error");
        }

        if (null != authTokenModel.getErrcode()) {
            return RPCResult.error(RPCResult.CODE_SERVER_ERROR, authTokenModel.getErrmsg());
        }

        String openId = authTokenModel.getOpenid();
        String sessionKey = authTokenModel.getSessionKey();

        if (StringUtils.isBlank(openId) || StringUtils.isBlank(sessionKey)) {
            return RPCResult.error(RPCResult.CODE_SERVER_ERROR, "openId or sessionKey lose");
        }

        // 放在redis中的sessionkey，本地产生的随机数
        String local3rdSessionKey = generateSessionKey();
        
        if (StringUtils.isBlank(local3rdSessionKey)) {
            return RPCResult.error(RPCResult.CODE_SERVER_ERROR, "generate local3rdSessionKey error");
        }

        // 通过openId查询是否已有用户信息
        userCenterModel = userCenterService.getUserCenterByOpenId(openId);

        if (null == userCenterModel) {
            // 没有信息，insert
            userCenterModel = new UserCenterModel();
            userCenterModel.setOpenId(openId);
            userCenterModel.setAvatarUrl(avatarUrl);
            userCenterModel.setCity(city);
            userCenterModel.setCountry(country);
            userCenterModel.setGender(gender);
            userCenterModel.setNickName(nickName);
            userCenterModel.setProvince(province);
            
            Integer result = userCenterService.login(userCenterModel);
            
            if (null == result || result < 1) {
                return RPCResult.error(RPCResult.CODE_SERVER_ERROR, RPCResult.MSG_SERVER_ERROR);
            }
        }

        // 重新从mysql中获取用户信息(获取id)
        userCenterModel = userCenterService.getUserCenterByOpenId(openId);

        Map<String, String> redisMap = new HashMap<String, String>();
        String userCenterModelJson = JSONObject.toJSONString(userCenterModel);
        redisMap.put(RedisMapKeyConstant.USER_CENTER_MODEL, userCenterModelJson);

        try {
            success = redisService.set(local3rdSessionKey, JSONObject.toJSONString(redisMap));
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }

        if (!success) {
            Log.error(
                String.format("redis add session fail, wxSessionCode = %s, local3rdSessionKey = %s, userInfo = %s",
                    wxSessionCode, local3rdSessionKey, userCenterModelJson));
        }

        res.put("wxLocalSessionId", local3rdSessionKey);

        return RPCResult.ok(res);
    }

    /**
     * 放在session中的key
     * 
     * @return
     */
    private String generateSessionKey() {
        String random = WXUtil.generateLocalRandom();
        if (random == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer(RedisPrefixConstant.USER_SESSION_PREFIX).append(random);
        return sb.toString();
    }
}
