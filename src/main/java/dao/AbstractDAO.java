package dao;

import java.util.Collection;
import java.util.List;

/**
 * 类AbstractDao.java的实现描述：抽象DAO方法类
 * 
 * @author jizhi.qy 2017年11月11日 上午11:09:56
 */
public interface AbstractDAO<D, P> {
    Integer insert(D dataObject);

    Integer count(P param);

    List<D> query(P param);

    Integer update(D dataObject);

    Integer delete(Long id);

    Integer update(D dataObject, Collection<String> changeSet);

    D find(Long id);
}
