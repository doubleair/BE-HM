package service;

import model.UserCenterModel;

/**
 * ��UserLoginService.java��ʵ���������û�����service
 * 
 * @author jizhi.qy 2017��11��11�� ����10:33:33
 */
public interface UserCenterService {
    int login(UserCenterModel model);

    UserCenterModel getUserCenterById(Long id);

    UserCenterModel getUserCenterByOpenId(String openId);
}
