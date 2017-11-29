package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.HuamingInfoDAO;
import dataObject.HuamingInfoDO;
import org.springframework.stereotype.Repository;
import param.HuamingInfoParam;

/**
 * 类HuamingInfoDAOImpl.java的实现描述：花名信息DAO实现类
 * 
 * @author jizhi.qy 2017年11月19日 下午2:45:41
 */
@Repository
public class HuamingInfoDAOImpl extends AbstractMyBatisDAO<HuamingInfoDO, HuamingInfoParam> implements HuamingInfoDAO {

    @Override
    public String getNameSpace() {
        return "huaming_info";
    }


}
