package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.UserCenterDAO;
import dataObject.UserCenterDO;
import model.UserCenterModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import param.UserCenterParam;

/**
 * 类UserLoginDAOImpl.java的实现描述：用户中心DAO实现类
 * 
 * @author jizhi.qy 2017年11月11日 上午10:40:49
 */
@Repository
public class UserCenterDAOImpl extends AbstractMyBatisDAO<UserCenterDO, UserCenterParam> implements UserCenterDAO {

    private static final Log Log = LogFactory.getLog(UserCenterDAOImpl.class);

    @Override
    public UserCenterModel getUserLoginModel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNameSpace() {
        return "user_center";
    }

}
