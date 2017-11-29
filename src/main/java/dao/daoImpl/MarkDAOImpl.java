package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.MarkDAO;
import dataObject.MarkDO;
import org.springframework.stereotype.Repository;
import param.MarkParam;

/**
 * 类MarkDAOImpl.java的实现描述：痕迹DAO实现类
 * 
 * @author jizhi.qy 2017年11月21日 上午12:27:26
 */
@Repository
public class MarkDAOImpl extends AbstractMyBatisDAO<MarkDO, MarkParam> implements MarkDAO {

    @Override
    public String getNameSpace() {
        return "mark";
    }

}
