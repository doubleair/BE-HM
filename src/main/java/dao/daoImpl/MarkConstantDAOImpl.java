package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.MarkConstantDAO;
import dataObject.MarkConstantDO;
import org.springframework.stereotype.Repository;
import param.MarkConstantParam;

/**
 * ��MarkConstantDAOImpl.java��ʵ���������ۼ�������Ŀ�б�DAOʵ����
 * 
 * @author jizhi.qy 2017��11��27�� ����9:32:48
 */
@Repository
public class MarkConstantDAOImpl extends AbstractMyBatisDAO<MarkConstantDO, MarkConstantParam>
    implements MarkConstantDAO {

    @Override
    public String getNameSpace() {
        return "mark_constant";
    }

}
