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
 * ��UserLoginDAOImpl.java��ʵ���������û�����DAOʵ����
 * 
 * @author jizhi.qy 2017��11��11�� ����10:40:49
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
