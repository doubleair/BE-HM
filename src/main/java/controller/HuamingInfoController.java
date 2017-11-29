package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;

import common.PageList;
import common.RPCResult;
import constants.RedisKeyConstant;
import constants.RedisMapKeyConstant;
import model.HuamingInfoModel;
import model.JianghuConstantModel;
import model.JianghuModel;
import model.MarkConstantModel;
import model.MarkModel;
import model.UserCenterModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import param.JianghuConstantParam;
import param.JianghuParam;
import param.MarkConstantParam;
import param.MarkParam;
import service.HuamingInfoService;
import service.JianghuConstantService;
import service.JianghuService;
import service.MarkConstantService;
import service.MarkService;
import service.RedisService;

/**
 * ��HuamingInfoController.java��ʵ������������controller
 * 
 * @author jizhi.qy 2017��11��20�� ����9:08:54
 */
@Controller
public class HuamingInfoController {
    private static final Log Log = LogFactory.getLog(HuamingInfoController.class);
    @Resource
    private HuamingInfoService huamingInfoService;
    @Resource
    private RedisService redisService;
    @Resource
    private JianghuService jianghuService;
    @Resource
    private MarkService markService;
    @Resource
    private MarkConstantService markConstantService;
    @Resource
    private JianghuConstantService jianghuConstantService;

    /**
     * ���»�����Ϣ�ӿ�
     * 1. ��redis��ȡ������Ϣ
     * 2. ���������ϢΪ�գ��򴴽�����model
     * 3. ����ǻ������߼�˵��Ϣ���£���ֱ�Ӳ�Ⲣ����redis
     * 4. ����ǽ������£������redis�л���model�е�jianghuModel����⣬����redis
     * 5. ����Ǻۼ����£������redis�л���model�е�markModel����⣬����redis
     * 
     * @param value ���µ�����
     * @param wxLocalSessionId
     * @param type 1.huaming 2.introduction 3.jianghu 4.mark
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/huamingInfo/update")
    public RPCResult updateUserInfo(
        @RequestParam(value = "value", required = false) String value,
        @RequestParam(value = "wxLocalSessionId", required = false) String wxLocalSessionId,
        @RequestParam(value = "type", required = false) String type) {

        UserCenterModel userCenterModel = null;
        Map<String, String> redisMap = redisService.getRedisMap(wxLocalSessionId);
        HuamingInfoModel huamingInfoModel = null;
        Integer res = null;
        boolean huamingInfoExist = true;
        HuamingInfoModel updateHuamingInfoModel = new HuamingInfoModel();

        // ��ȡuserInfoModel
        {
            if (null == redisMap || StringUtils.isBlank(redisMap.get(RedisMapKeyConstant.USER_CENTER_MODEL))) {
                return RPCResult.error(RPCResult.CODE_SESSION_EXPIRE, RPCResult.MSG_SESSION_EXPIRE);
            }

            try {
                userCenterModel =
                    JSONObject.parseObject(redisMap.get(RedisMapKeyConstant.USER_CENTER_MODEL), UserCenterModel.class);
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
            }

            if (null == userCenterModel) {
                return RPCResult.error(RPCResult.CODE_SESSION_EXPIRE, RPCResult.MSG_SESSION_EXPIRE);
            }

            huamingInfoModel = getHuamingInfoModelWithRedisMap(redisMap);

            if (null == huamingInfoModel) {
                try {
                    huamingInfoModel = huamingInfoService.getHuamingModelByOpenId(userCenterModel.getOpenId());
                } catch (Exception e) {
                    Log.error(e.getMessage(), e);
                    return RPCResult.error(RPCResult.CODE_SERVER_ERROR, RPCResult.MSG_SERVER_ERROR);
                }
            }
        }

        // ��ȡ������Ϣ������У��͸��£����û�оͲ���
        if (null == huamingInfoModel) {
            updateHuamingInfoModel.setUserCenterId(userCenterModel.getId());
            updateHuamingInfoModel.setOpenId(userCenterModel.getOpenId());
            huamingInfoExist = false;
        } else {
            updateHuamingInfoModel.setId(huamingInfoModel.getId());
        }

        if ("huaming".equals(type) || "introduction".equals(type)) {
            if ("huaming".equals(type)) {
                // �޸Ļ���
                updateHuamingInfoModel.setHuaming(value);
            } else if ("introduction".equals(type)) {
                // �޸ļ�˵
                updateHuamingInfoModel.setIntroduction(value);
            }

            res = updateHuamingInfo(updateHuamingInfoModel, huamingInfoExist);

            if (res != null && res == 1 && StringUtils.isNotBlank(userCenterModel.getOpenId())) {

                huamingInfoModel = huamingInfoService.getHuamingModelByOpenId(userCenterModel.getOpenId());
                redisMap.put(RedisMapKeyConstant.HUAMING_INFO_MODEL, JSONObject.toJSONString(huamingInfoModel));
                redisService.set(wxLocalSessionId, JSONObject.toJSONString(redisMap));
            }
        } else if ("jianghu".equals(type) || "mark".equals(type)) {
            if ("jianghu".equals(type)) {
                // �޸Ľ���
                try {
                    // ������Ϣ
                    JianghuModel jianghuModel = JSONObject.parseObject(value, JianghuModel.class);
                    jianghuModel.setOpenId(userCenterModel.getOpenId());
                    if (null == jianghuModel.getId()) {
                        // ����
                        res = jianghuService.create(jianghuModel);
                    } else {
                        // �޸�
                        Boolean result = jianghuService.update(jianghuModel);
                        if (null != result && result) {
                            res = 1;
                        }
                    }

                    // ����redis
                    if (res == 1) {
                        JianghuParam param = new JianghuParam();
                        param.setOpenId(userCenterModel.getOpenId());

                        List<JianghuModel> modelList = jianghuService.queryWithoutPage(param);
                        huamingInfoModel.setJianghuModelList(modelList);
                        redisMap.put(RedisMapKeyConstant.HUAMING_INFO_MODEL, JSONObject.toJSONString(huamingInfoModel));
                        redisService.set(wxLocalSessionId, JSONObject.toJSONString(redisMap));
                    }
                } catch (Exception e) {
                    Log.error(e.getMessage(), e);
                    return RPCResult.error(RPCResult.CODE_PARAM_ERROR, RPCResult.MSG_PARAM_ERROR);
                }
            } else if ("mark".equals(type)) {
                // �޸��㼣
                try {
                    // ������Ϣ
                    MarkModel markModel = JSONObject.parseObject(value, MarkModel.class);
                    markModel.setOpenId(userCenterModel.getOpenId());
                    if (null == markModel.getId()) {
                        // ����
                        res = markService.create(markModel);
                    } else {
                        // ����
                        Boolean result = markService.update(markModel);
                        if (null != result && result) {
                            res = 1;
                        }
                    }

                    // ����redis
                    if (null != res && res == 1) {
                        MarkParam param = new MarkParam();
                        param.setOpenId(userCenterModel.getOpenId());

                        List<MarkModel> modelList = markService.queryWithoutPage(param);

                        huamingInfoModel.setMarkModelList(modelList);
                        redisMap.put(RedisMapKeyConstant.HUAMING_INFO_MODEL, JSONObject.toJSONString(huamingInfoModel));
                        redisService.set(wxLocalSessionId, JSONObject.toJSONString(redisMap));
                    }
                } catch (Exception e) {
                    Log.error(e.getMessage(), e);
                    return RPCResult.error(RPCResult.CODE_PARAM_ERROR, RPCResult.MSG_PARAM_ERROR);
                }
            }
        } else {
            return RPCResult.error(RPCResult.CODE_PARAM_ERROR, RPCResult.MSG_PARAM_ERROR);
        }

        if (null == res || res < 1) {
            return RPCResult.error(RPCResult.CODE_SERVER_ERROR, RPCResult.MSG_SERVER_ERROR);
        }

        return RPCResult.ok();
    }

    /**
     * ��ȡ�û��Ļ�����Ϣ
     * 
     * @param wxLocalSessionId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/huamingInfo/getInfo")
    public RPCResult
        getHuamingInfo(@RequestParam(value = "wxLocalSessionId", required = false) String wxLocalSessionId) {
        
        Map<String, String> redisMap = redisService.getRedisMap(wxLocalSessionId);
        String userCenterModelJson = redisMap.get(RedisMapKeyConstant.USER_CENTER_MODEL);
        UserCenterModel userCenterModel = null;
        HuamingInfoModel huamingInfoModel = null;
        Map<String, String> res = new HashMap<String, String>();
        
        // ��ȡ�û���Ϣ
        {
            if (null == redisMap || StringUtils.isBlank(userCenterModelJson)) {
                return RPCResult.error(RPCResult.CODE_SESSION_EXPIRE, RPCResult.MSG_SESSION_EXPIRE);
            }
            
            try {
                userCenterModel = JSONObject.parseObject(userCenterModelJson, UserCenterModel.class);
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
                return RPCResult.error(RPCResult.CODE_SERVER_ERROR, RPCResult.MSG_SERVER_ERROR);
            }
            
            if (userCenterModel == null) {
                return RPCResult.error(RPCResult.CODE_SERVER_ERROR, RPCResult.MSG_SERVER_ERROR);
            }
        }
        
        // �������������Ϣ
        String huamingInfoModelJson = redisMap.get(RedisMapKeyConstant.HUAMING_INFO_MODEL);
        if (!StringUtils.isBlank(huamingInfoModelJson)) {
            try {
                huamingInfoModel = JSONObject.parseObject(huamingInfoModelJson, HuamingInfoModel.class);
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
                return RPCResult.error(RPCResult.CODE_SERVER_ERROR, RPCResult.MSG_SERVER_ERROR);
            }
        }
        
        // db�л�����Ϣ
        if (null == huamingInfoModel) {
            try {
                huamingInfoModel = huamingInfoService.getHuamingModelByOpenId(userCenterModel.getOpenId());
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
                return RPCResult.error(RPCResult.CODE_SERVER_ERROR, RPCResult.MSG_SERVER_ERROR);
            }
        }

        if (null == huamingInfoModel) {
            res.put("data", huamingInfoModelJson);
            return RPCResult.ok(res);
        }

        if (huamingInfoModel.getJianghuModelList() == null) {
            try {
                JianghuParam param = new JianghuParam();
                param.setOpenId(userCenterModel.getOpenId());
                PageList<JianghuModel> jianghuModelPageList = jianghuService.query(param);
                if (jianghuModelPageList != null) {
                    huamingInfoModel.setJianghuModelList(jianghuModelPageList.getDataList());
                }
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
                return RPCResult.error(RPCResult.CODE_SERVER_ERROR, RPCResult.MSG_SERVER_ERROR);
            }
        }

        if (huamingInfoModel.getMarkModelList() == null) {
            try {
                MarkParam param = new MarkParam();
                param.setOpenId(userCenterModel.getOpenId());
                PageList<MarkModel> markModelPageList = markService.query(param);
                if (markModelPageList != null) {
                    huamingInfoModel.setMarkModelList(markModelPageList.getDataList());
                }
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
                return RPCResult.error(RPCResult.CODE_SERVER_ERROR, RPCResult.MSG_SERVER_ERROR);
            }
        }

        if (huamingInfoModelJson == null) {
            huamingInfoModelJson = JSONObject.toJSONString(huamingInfoModel);
            redisMap.put(RedisMapKeyConstant.HUAMING_INFO_MODEL, huamingInfoModelJson);
            try {
                redisService.set(wxLocalSessionId, JSONObject.toJSONString(redisMap));
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
            }
        }

        res.put("data", huamingInfoModelJson);
        return RPCResult.ok(res);
    }

    /**
     * ��ȡmark��id���������б�Ϊ�̶�ֵ��
     * ��redis��ȡ���ò����ʹ����ݿ���
     * 
     * @param wxLocalSessionId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/huamingInfo/getMarkCategory")
    public RPCResult getMarkCategory() {
        String markInfo = (String)redisService.get(RedisKeyConstant.HUAMING_MARKINFO);
        List<MarkConstantModel> list = new ArrayList<MarkConstantModel>();
        if (!StringUtils.isBlank(markInfo)) {
            list = JSONObject.parseArray(markInfo, MarkConstantModel.class);
        } else {
            MarkConstantParam param = new MarkConstantParam();
            try {
                PageList<MarkConstantModel> markConstantPageList = markConstantService.query(param);
                if (null != markConstantPageList && null != markConstantPageList.getDataList()) {
                    list = markConstantPageList.getDataList();
                    String listJson = JSONObject.toJSONString(list);
                    redisService.set(RedisKeyConstant.HUAMING_MARKINFO, listJson);
                }
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
            }
        }

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", list);
        return RPCResult.ok(res);
    }

    /**
     * ��ȡjianghu��id���������б�Ϊ�̶�ֵ��
     * ��redis��ȡ���ò����ʹ����ݿ���
     * 
     * @param wxLocalSessionId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/huamingInfo/getJianghuCategory")
    public RPCResult getJianghuCategory() {
        String jianghuInfo = (String)redisService.get(RedisKeyConstant.HUAMING_JIANGHUINFO);
        List<JianghuConstantModel> list = new ArrayList<JianghuConstantModel>();
        if (!StringUtils.isBlank(jianghuInfo)) {
            list = JSONObject.parseArray(jianghuInfo, JianghuConstantModel.class);
        } else {
            JianghuConstantParam param = new JianghuConstantParam();
            try {
                PageList<JianghuConstantModel> jianghuConstantPageList = jianghuConstantService.query(param);
                if (null != jianghuConstantPageList && null != jianghuConstantPageList.getDataList()) {
                    list = jianghuConstantPageList.getDataList();
                    String listJson = JSONObject.toJSONString(list);
                    redisService.set(RedisKeyConstant.HUAMING_JIANGHUINFO, listJson);
                }
            } catch (Exception e) {
                Log.error(e.getMessage(), e);
            }
        }

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("data", list);
        return RPCResult.ok(res);
    }

    /**
     * �Ի�����Ϣ���»����
     * 
     * @param huamingInfoModel
     * @param update true��update��false��insert
     * @return
     */
    private Integer updateHuamingInfo(HuamingInfoModel huamingInfoModel, boolean update) {
        if (update) {
            Boolean res = huamingInfoService.update(huamingInfoModel);
            if (null != res && res) {
                return 1;
            }
            return 0;
        } else {
            return huamingInfoService.create(huamingInfoModel);
        }
    }

    /**
     * ͨ��redisMap����ȡ������Ϣ
     * 
     * @param redisMap
     * @return
     */
    private HuamingInfoModel getHuamingInfoModelWithRedisMap(Map<String, String> redisMap) {
        if (null == redisMap) {
            return null;
        }
        String huamingInfoModelJson = redisMap.get(RedisMapKeyConstant.HUAMING_INFO_MODEL);
        if (StringUtils.isBlank(huamingInfoModelJson)) {
            return null;
        }

        HuamingInfoModel model = null;
        try {
            model = JSONObject.parseObject(huamingInfoModelJson, HuamingInfoModel.class);
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return model;
    }
}
