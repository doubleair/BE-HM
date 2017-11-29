package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import dataObject.AbstractDO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.util.CollectionUtils;
import param.AbstractParam;

/**
 * 类AbstractMybatisDAO.java的实现描述：抽象MyBatis基础DAO
 * 
 * @author jizhi.qy 2017年11月11日 上午11:23:16
 */
public abstract class AbstractMyBatisDAO<D extends AbstractDO, P extends AbstractParam> implements AbstractDAO<D, P> {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public abstract String getNameSpace();

    public Integer insert(final D t, final String sql) {
        if (t == null) {
            return 0;
        }
        return getSqlSessionTemplate().insert(sql, t);
    }

    public Integer insert(final D t) {
        return insert(t, constructSQLName("create"));
    }

    public Integer delete(final Long id, final String sql) {
        if (id == null || id <= 0) {
            return 0;
        }
        return getSqlSessionTemplate().delete(sql, id);
    }

    public Integer delete(final Long id) {
        return delete(id, constructSQLName("delete_by_id"));
    }

    public Integer update(final D t, final String sql) {
        if (t == null || t.getId() == null || t.getId() <= 0) {
            return 0;
        }
        final Map<String, Object> params = new HashMap<String, Object>();

        params.put("this", t);
        return getSqlSessionTemplate().update(sql, params);
    }

    public Integer update(final D t, final Collection<String> changeSet, final String sql) {
        if (t == null || t.getId() == null || t.getId() <= 0) {
            return 0;
        }
        final Map<String, Object> params = new HashMap<String, Object>();

        if (!CollectionUtils.isEmpty(changeSet)) {
            for (String change : changeSet) {
                params.put(change, "");
            }
        }
        params.put("this", t);
        return getSqlSessionTemplate().update(sql, params);
    }

    public Integer update(final D t, final Collection<String> changeSet) {
        return update(t, changeSet, constructSQLName("update_partial"));
    }

    public Integer update(final D t) {
        return update(t, constructSQLName("update"));
    }

    @SuppressWarnings("unchecked")
    public D find(final Long id, final String sql) {
        return (D)getSqlSessionTemplate().selectOne(sql, id);
    }

    public D find(final Long id) {
        return find(id, constructSQLName("find_by_id"));
    }

    @SuppressWarnings("unchecked")
    public List<D> query(final Map<String, Object> params, final String sql) {
        return (List<D>)(Object)getSqlSessionTemplate().selectList(sql, params);
    }

    public List<D> query(final P param) {
        return query(param.toParamMap(), constructSQLName("find_by_param"));
    }

    public Integer count(final Map<String, Object> params, final String sql) {
        return (Integer)getSqlSessionTemplate().selectOne(sql, params);
    }

    public Integer count(final P param) {
        return count(param.toParamMap(), constructSQLName("count"));
    }

    protected String constructSQLName(final String id) {
        return getNameSpace() + "." + getNameSpace() + "_" + id;
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }


}
