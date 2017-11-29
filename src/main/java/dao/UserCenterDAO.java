package dao;

import dataObject.UserCenterDO;
import model.UserCenterModel;
import param.UserCenterParam;

/**
 * ��UserLoginDAO.java��ʵ���������û�����DAO
 * 
 * @author jizhi.qy 2017��11��11�� ����10:39:38
 */
public interface UserCenterDAO extends AbstractDAO<UserCenterDO, UserCenterParam> {

    UserCenterModel getUserLoginModel();
}
