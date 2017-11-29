package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.JianghuDAO;
import dataObject.JianghuDO;
import org.springframework.stereotype.Repository;
import param.JianghuParam;

/**
 * ��JianghuDAOImpl.java��ʵ������������DAOʵ����
 * 
 * @author jizhi.qy 2017��11��21�� ����12:42:48
 */
@Repository
public class JianghuDAOImpl extends AbstractMyBatisDAO<JianghuDO, JianghuParam> implements JianghuDAO {

    @Override
    public String getNameSpace() {
        return "jianghu";
    }

}
