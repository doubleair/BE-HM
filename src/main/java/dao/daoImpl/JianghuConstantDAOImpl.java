package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.JianghuConstantDAO;
import dataObject.JianghuConstantDO;
import org.springframework.stereotype.Repository;
import param.JianghuConstantParam;

/**
 * ��MarkConstantDAOImpl.java��ʵ������������������Ŀ�б�DAOʵ����
 * 
 * @author jizhi.qy 2017��11��27�� ����9:32:48
 */
@Repository
public class JianghuConstantDAOImpl extends AbstractMyBatisDAO<JianghuConstantDO, JianghuConstantParam>
    implements JianghuConstantDAO {

    @Override
    public String getNameSpace() {
        return "jianghu_constant";
    }

}
