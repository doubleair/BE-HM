package mapper;

import dataObject.HuamingInfoDO;
import model.HuamingInfoModel;
import org.springframework.stereotype.Repository;

/**
 * 类HuamingInfoMapper.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月19日 下午2:46:38
 */
@Repository
public class HuamingInfoMapper implements Mapper<HuamingInfoModel, HuamingInfoDO> {

    @Override
    public HuamingInfoDO toDO(HuamingInfoModel m) {
        HuamingInfoDO huamingInfoDO = new HuamingInfoDO();
        huamingInfoDO.setId(m.getId());
        huamingInfoDO.setGmtCreate(m.getGmtCreate());
        huamingInfoDO.setGmtModified(m.getGmtModified());
        huamingInfoDO.setHuaming(m.getHuaming());
        huamingInfoDO.setIntroduction(m.getIntroduction());
        huamingInfoDO.setOpenId(m.getOpenId());
        huamingInfoDO.setUserCenterId(m.getUserCenterId());
        return huamingInfoDO;
    }

    @Override
    public HuamingInfoModel toModel(HuamingInfoDO d) {
        HuamingInfoModel huamingInfoModel = new HuamingInfoModel();
        huamingInfoModel.setId(d.getId());
        huamingInfoModel.setGmtCreate(d.getGmtCreate());
        huamingInfoModel.setGmtModified(d.getGmtModified());
        huamingInfoModel.setHuaming(d.getHuaming());
        huamingInfoModel.setIntroduction(d.getIntroduction());
        huamingInfoModel.setOpenId(d.getOpenId());
        huamingInfoModel.setUserCenterId(d.getUserCenterId());

        return huamingInfoModel;
    }

}
