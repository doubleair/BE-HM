package dao;

import dataObject.UserCenterDO;
import model.UserCenterModel;
import param.UserCenterParam;

/**
 * 类UserLoginDAO.java的实现描述：用户中心DAO
 * 
 * @author jizhi.qy 2017年11月11日 上午10:39:38
 */
public interface UserCenterDAO extends AbstractDAO<UserCenterDO, UserCenterParam> {

    UserCenterModel getUserLoginModel();
}
