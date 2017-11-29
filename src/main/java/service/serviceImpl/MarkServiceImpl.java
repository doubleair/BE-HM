package service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import dao.AbstractDAO;
import dao.MarkDAO;
import dataObject.MarkDO;
import mapper.Mapper;
import mapper.MarkMapper;
import model.MarkModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import param.MarkParam;
import service.DefaultService;
import service.MarkService;

/**
 * 类MarkServiceImpl.java的实现描述：痕迹信息service实现类
 * 
 * @author jizhi.qy 2017年11月21日 上午12:21:52
 */
@Service
public class MarkServiceImpl extends DefaultService<MarkModel, MarkDO, MarkParam> implements MarkService {

    private static final Log Log = LogFactory.getLog(MarkServiceImpl.class);

    @Resource
    private MarkDAO markDAO;
    @Resource
    private MarkMapper markMapper;

    @Override
    public AbstractDAO<MarkDO, MarkParam> getDao() {
        return markDAO;
    }

    @Override
    public Mapper<MarkModel, MarkDO> getMapper() {
        return markMapper;
    }

    @Override
    public Boolean update(MarkModel model) {
        return super.update(model);
    }

    @Override
    public Integer create(MarkModel model) {
        return super.create(model);
    }

    @Override
    public List<MarkModel> queryWithoutPage(MarkParam param) {
        List<MarkDO> markDOList = this.getDao().query(param);
        List<MarkModel> markModelList = new ArrayList<MarkModel>();
        for (MarkDO markDO : markDOList) {
            markModelList.add(this.getMapper().toModel(markDO));
        }
        return markModelList;
    }

}
