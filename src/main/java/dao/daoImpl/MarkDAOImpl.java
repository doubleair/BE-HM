package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.MarkDAO;
import dataObject.MarkDO;
import org.springframework.stereotype.Repository;
import param.MarkParam;

/**
 * ��MarkDAOImpl.java��ʵ���������ۼ�DAOʵ����
 * 
 * @author jizhi.qy 2017��11��21�� ����12:27:26
 */
@Repository
public class MarkDAOImpl extends AbstractMyBatisDAO<MarkDO, MarkParam> implements MarkDAO {

    @Override
    public String getNameSpace() {
        return "mark";
    }

}
