package dao.daoImpl;

import dao.AbstractMyBatisDAO;
import dao.JianghuDAO;
import dataObject.JianghuDO;
import org.springframework.stereotype.Repository;
import param.JianghuParam;

/**
 * 类JianghuDAOImpl.java的实现描述：江湖DAO实现类
 * 
 * @author jizhi.qy 2017年11月21日 上午12:42:48
 */
@Repository
public class JianghuDAOImpl extends AbstractMyBatisDAO<JianghuDO, JianghuParam> implements JianghuDAO {

    @Override
    public String getNameSpace() {
        return "jianghu";
    }

}
