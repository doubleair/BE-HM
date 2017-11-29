package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.JianghuConstantDAO;
import dataObject.JianghuConstantDO;
import org.springframework.stereotype.Repository;
import param.JianghuConstantParam;

/**
 * 类MarkConstantDAOImpl.java的实现描述：江湖常量类目列表DAO实现类
 * 
 * @author jizhi.qy 2017年11月27日 下午9:32:48
 */
@Repository
public class JianghuConstantDAOImpl extends AbstractMyBatisDAO<JianghuConstantDO, JianghuConstantParam>
    implements JianghuConstantDAO {

    @Override
    public String getNameSpace() {
        return "jianghu_constant";
    }

}
