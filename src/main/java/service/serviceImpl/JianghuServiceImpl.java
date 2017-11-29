/*
 * Copyright 2017 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import dao.AbstractDAO;
import dao.JianghuDAO;
import dataObject.JianghuDO;
import mapper.JianghuMapper;
import mapper.Mapper;
import model.JianghuModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import param.JianghuParam;
import service.DefaultService;
import service.JianghuService;

/**
 * 类JianghuServiceImpl.java的实现描述：江湖信息service实现类
 * 
 * @author jizhi.qy 2017年11月21日 上午12:31:39
 */
@Service
public class JianghuServiceImpl extends DefaultService<JianghuModel, JianghuDO, JianghuParam>
    implements JianghuService {

    private static final Log Log = LogFactory.getLog(JianghuServiceImpl.class);

    @Resource
    private JianghuDAO jianghuDAO;
    @Resource
    private JianghuMapper jianghuMapper;

    @Override
    public AbstractDAO<JianghuDO, JianghuParam> getDao() {
        return this.jianghuDAO;
    }

    @Override
    public Mapper<JianghuModel, JianghuDO> getMapper() {
        return this.jianghuMapper;
    }

    @Override
    public JianghuModel getJianghuModelById() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JianghuModel getJianghuModelByOpenId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer create(JianghuModel jianghuModel) {
        return super.create(jianghuModel);
    }

    @Override
    public Boolean update(JianghuModel jianghuModel) {
        return super.update(jianghuModel);
    }

    @Override
    public List<JianghuModel> queryWithoutPage(JianghuParam param) {
        List<JianghuDO> jianghuDOList = this.getDao().query(param);
        List<JianghuModel> jianghuModelList = new ArrayList<JianghuModel>();
        for (JianghuDO jianghuDO : jianghuDOList) {
            jianghuModelList.add(this.getMapper().toModel(jianghuDO));
        }
        return jianghuModelList;
    }

}
