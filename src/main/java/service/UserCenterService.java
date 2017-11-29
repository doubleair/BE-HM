package service;

import model.UserCenterModel;

/**
 * 类UserLoginService.java的实现描述：用户中心service
 * 
 * @author jizhi.qy 2017年11月11日 上午10:33:33
 */
public interface UserCenterService {
    int login(UserCenterModel model);

    UserCenterModel getUserCenterById(Long id);

    UserCenterModel getUserCenterByOpenId(String openId);
}
