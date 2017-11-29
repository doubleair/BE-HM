package service;

import java.util.ArrayList;
import java.util.List;

import common.PageList;
import common.Paginator;
import dao.AbstractDAO;
import mapper.Mapper;
import model.AbstractModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;
import param.AbstractParam;

/**
 * 类DefaultService.java的实现描述：抽象service
 * 
 * @author jizhi.qy 2017年11月11日 上午10:53:39
 */
public abstract class DefaultService<M extends AbstractModel, D, P extends AbstractParam> {

    private static final Log Log = LogFactory.getLog(DefaultService.class);

    // 创建
    public Integer create(M model) {
        if (null == model) {
            Log.error("model is null");
        }
        final D theDO = getMapper().toDO(model);
        if (theDO == null) {
            return 0;
        }
        return getDao().insert(theDO);
    }


    public Boolean delete(Long id) {
        if (null == id) {
            Log.error("id is null");
        }
        return getDao().delete(id) > 0;
    }

    public Boolean update(M model) {
        return update(model, false);
    }

    public Boolean update(M model, boolean isFullUpdate) {
        if (null == model) {
            Log.error("model is null");
        }
        final D theDO = getMapper().toDO(model);
        if (theDO == null) {
            return false;
        }
        Integer result = null;
        if (isFullUpdate) {
            result = getDao().update(theDO);
        } else {
            result = getDao().update(theDO, model.changeSet());
        }
        return result != null && result > 0;
    }

    public M find(Long id) {
        if (null == id) {
            Log.error("model is null");
        }
        return getMapper().toModel(getDao().find(id));
    }

    public PageList<M> query(P param) {
        final PageList<M> result = new PageList<M>();
        if (param == null) {
            return result;
        }
        try {
            final List<D> doList = getDao().query(param);
            if (param.isPaged()) {
                final Paginator paginator = new Paginator(param.getPageSize());
                paginator.setPage(param.getPage());
                result.setPaginator(paginator);
                if (param.isCountNeeded()) {
                    Integer count = 0;
                    if (doList == null || doList.size() == 0) {
                        count = 0;
                    } else {
                        count = getDao().count(param);
                    }
                    paginator.setItems(count);
                }
            }
            final List<M> models = new ArrayList<M>();
            if (doList != null) {
                for (D aDO : doList) {
                    final M model = getMapper().toModel(aDO);
                    if (model != null) {
                        models.add(model);
                    }
                }
            }
            result.setDataList(models);
        } catch (Exception e) {
            Log.error("failed to query models by param " + param, e);
        }
        return result;
    }

    public M queryOne(P param, Boolean selectFirst) {
        if (param == null) {
            return null;
        }
        final List<D> doList = getDao().query(param);
        if (CollectionUtils.isEmpty(doList)) {
            return null;
        }
        if (doList.size() > 1 && !selectFirst) {
            Log.error("Redundant data, size is " + doList.size());
        }
        return getMapper().toModel(doList.get(0));
    }

    public Integer count(P param) {
        return getDao().count(param);
    }

    abstract public AbstractDAO<D, P> getDao();

    abstract public Mapper<M, D> getMapper();
}
