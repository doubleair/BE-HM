package service.serviceImpl;

import javax.annotation.Resource;

import dao.AbstractDAO;
import dao.JianghuConstantDAO;
import dataObject.JianghuConstantDO;
import mapper.JianghuConstantMapper;
import mapper.Mapper;
import model.JianghuConstantModel;
import org.springframework.stereotype.Service;
import param.JianghuConstantParam;
import service.DefaultService;
import service.JianghuConstantService;

/**
 * 类MarkConstantServiceImpl.java的实现描述：江湖常量类目列表信息service实现类
 * 
 * @author jizhi.qy 2017年11月27日 下午9:24:03
 */
@Service
public class JianghuConstantServiceImpl
    extends DefaultService<JianghuConstantModel, JianghuConstantDO, JianghuConstantParam>
    implements JianghuConstantService {

    @Resource
    private JianghuConstantDAO jianghuConstantDAO;
    @Resource
    private JianghuConstantMapper jianghuConstantMapper;

    @Override
    public AbstractDAO<JianghuConstantDO, JianghuConstantParam> getDao() {
        return this.jianghuConstantDAO;
    }

    @Override
    public Mapper<JianghuConstantModel, JianghuConstantDO> getMapper() {
        return this.jianghuConstantMapper;
    }

}
