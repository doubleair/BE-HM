package service.serviceImpl;

import java.util.List;

import dao.AbstractDAO;
import dao.HuamingInfoDAO;
import dataObject.HuamingInfoDO;
import mapper.HuamingInfoMapper;
import mapper.Mapper;
import model.HuamingInfoModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import param.HuamingInfoParam;
import service.DefaultService;
import service.HuamingInfoService;

/**
 * 类HuamingInfoServiceImpl.java的实现描述：花名信息service实现类
 * 
 * @author jizhi.qy 2017年11月19日 下午2:42:21
 */
@Service
public class HuamingInfoServiceImpl extends DefaultService<HuamingInfoModel, HuamingInfoDO, HuamingInfoParam>
    implements HuamingInfoService {

    private static final Log Log = LogFactory.getLog(HuamingInfoServiceImpl.class);

    @Autowired
    private HuamingInfoDAO huamingInfoDAO;
    @Autowired
    private HuamingInfoMapper huamingInfoMapper;

    @Override
    public AbstractDAO<HuamingInfoDO, HuamingInfoParam> getDao() {
        return huamingInfoDAO;
    }

    @Override
    public Mapper<HuamingInfoModel, HuamingInfoDO> getMapper() {
        return huamingInfoMapper;
    }

    @Override
    public HuamingInfoModel getHuamingModelById(Long id) {
        HuamingInfoDO huamingInfoDO = getDao().find(id);
        HuamingInfoModel model = getMapper().toModel(huamingInfoDO);
        return model;
    }

    @Override
    public HuamingInfoModel getHuamingModelByOpenId(String openId) {
        HuamingInfoParam param = new HuamingInfoParam();
        param.setOpenId(openId);
        List<HuamingInfoDO> doList = getDao().query(param);
        if (null == doList || doList.size() == 0) {
            return null;
        }
        return getMapper().toModel(doList.get(0));
    }

    @Override
    public Integer create(HuamingInfoModel model) {
        return super.create(model);
    }

    @Override
    public Boolean update(HuamingInfoModel model) {
        return super.update(model);
    }
}
