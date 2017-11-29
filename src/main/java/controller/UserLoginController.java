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
 * �û�controller
 * 
 * @author jizhi.qy 2017��11��6�� ����10:32:24
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
     * ��¼�ӿڣ����̣�
     * 1. ����wxSessionCode
     * 2. ��wx��������ȡ�û�session��openId
     * 3. ���ɱ���������session
     * 4. session��Ϣд��redis
     * 5. �鿴���û��Ƿ��Ѿ�ע�ᣬע���(�͸�����Ϣ)��ûע����Ͳ�����Ϣ
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

        // ��΢�ŷ�������ȡ�û�openId��sessionKey����
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

        // ����redis�е�sessionkey�����ز����������
        String local3rdSessionKey = generateSessionKey();
        
        if (StringUtils.isBlank(local3rdSessionKey)) {
            return RPCResult.error(RPCResult.CODE_SERVER_ERROR, "generate local3rdSessionKey error");
        }

        // ͨ��openId��ѯ�Ƿ������û���Ϣ
        userCenterModel = userCenterService.getUserCenterByOpenId(openId);

        if (null == userCenterModel) {
            // û����Ϣ��insert
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

        // ���´�mysql�л�ȡ�û���Ϣ(��ȡid)
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
     * ����session�е�key
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
