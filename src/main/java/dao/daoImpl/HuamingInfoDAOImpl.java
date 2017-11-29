package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.HuamingInfoDAO;
import dataObject.HuamingInfoDO;
import org.springframework.stereotype.Repository;
import param.HuamingInfoParam;

/**
 * ��HuamingInfoDAOImpl.java��ʵ��������������ϢDAOʵ����
 * 
 * @author jizhi.qy 2017��11��19�� ����2:45:41
 */
@Repository
public class HuamingInfoDAOImpl extends AbstractMyBatisDAO<HuamingInfoDO, HuamingInfoParam> implements HuamingInfoDAO {

    @Override
    public String getNameSpace() {
        return "huaming_info";
    }


}
