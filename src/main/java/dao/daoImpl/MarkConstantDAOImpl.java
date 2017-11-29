package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.MarkConstantDAO;
import dataObject.MarkConstantDO;
import org.springframework.stereotype.Repository;
import param.MarkConstantParam;

/**
 * 类MarkConstantDAOImpl.java的实现描述：痕迹常量类目列表DAO实现类
 * 
 * @author jizhi.qy 2017年11月27日 下午9:32:48
 */
@Repository
public class MarkConstantDAOImpl extends AbstractMyBatisDAO<MarkConstantDO, MarkConstantParam>
    implements MarkConstantDAO {

    @Override
    public String getNameSpace() {
        return "mark_constant";
    }

}
