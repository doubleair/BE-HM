package dao;

import java.util.Collection;
import java.util.List;

/**
 * ��AbstractDao.java��ʵ������������DAO������
 * 
 * @author jizhi.qy 2017��11��11�� ����11:09:56
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
