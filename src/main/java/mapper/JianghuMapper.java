/*
 * Copyright 2017 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package mapper;

import dataObject.JianghuDO;
import model.JianghuModel;
import org.springframework.stereotype.Repository;

/**
 * 类JianghuMapper.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月21日 上午12:41:04
 */
@Repository
public class JianghuMapper implements Mapper<JianghuModel, JianghuDO> {

    @Override
    public JianghuDO toDO(JianghuModel m) {
        JianghuDO jianghuDO = new JianghuDO();
        jianghuDO.setId(m.getId());
        jianghuDO.setOpenId(m.getOpenId());
        jianghuDO.setDescription(m.getDescription());
        jianghuDO.setTypeId(m.getTypeId());
        jianghuDO.setSite(m.getSite());
        jianghuDO.setCnName(m.getCnName());
        return jianghuDO;
    }

    public JianghuModel toModel(JianghuDO d) {
        JianghuModel model = new JianghuModel();
        model.setId(d.getId());
        model.setTypeId(d.getTypeId());
        model.setCnName(d.getCnName());
        model.setDescription(d.getDescription());
        model.setOpenId(d.getOpenId());
        model.setSite(d.getSite());
        model.setGmtCreate(d.getGmtCreate());
        model.setGmtModified(d.getGmtModified());
        return model;
    }

}
