/*
 * Copyright 2017 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package mapper;

import dataObject.MarkDO;
import model.MarkModel;
import org.springframework.stereotype.Repository;

/**
 * 类MarkMapper.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月21日 上午12:23:31
 */
@Repository
public class MarkMapper implements Mapper<MarkModel, MarkDO> {

    @Override
    public MarkDO toDO(MarkModel m) {
        MarkDO markDO = new MarkDO();
        markDO.setId(m.getId());
        markDO.setGmtCreate(m.getGmtCreate());
        markDO.setGmtModified(m.getGmtModified());
        markDO.setTypeId(m.getTypeId());
        markDO.setCnName(m.getCnName());
        markDO.setDescription(m.getDescription());
        markDO.setOpenId(m.getOpenId());
        return markDO;
    }

    @Override
    public MarkModel toModel(MarkDO d) {
        MarkModel model = new MarkModel();
        model.setId(d.getId());
        model.setGmtCreate(d.getGmtCreate());
        model.setGmtModified(d.getGmtModified());
        model.setTypeId(d.getTypeId());
        model.setCnName(d.getCnName());
        model.setDescription(d.getDescription());
        model.setOpenId(d.getOpenId());
        return model;
    }

}
