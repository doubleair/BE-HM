package service.serviceImpl;

import javax.annotation.Resource;

import dao.AbstractDAO;
import dao.MarkConstantDAO;
import dataObject.MarkConstantDO;
import mapper.Mapper;
import mapper.MarkConstantMapper;
import model.MarkConstantModel;
import org.springframework.stereotype.Service;
import param.MarkConstantParam;
import service.DefaultService;
import service.MarkConstantService;

/**
 * ��MarkConstantServiceImpl.java��ʵ���������ۼ�������Ŀ�б���Ϣserviceʵ����
 * 
 * @author jizhi.qy 2017��11��27�� ����9:24:03
 */
@Service
public class MarkConstantServiceImpl extends DefaultService<MarkConstantModel, MarkConstantDO, MarkConstantParam>
    implements MarkConstantService {

    @Resource
    private MarkConstantDAO markConstantDAO;
    @Resource
    private MarkConstantMapper markConstantMapper;

    @Override
    public AbstractDAO<MarkConstantDO, MarkConstantParam> getDao() {
        return this.markConstantDAO;
    }

    @Override
    public Mapper<MarkConstantModel, MarkConstantDO> getMapper() {
        return this.markConstantMapper;
    }

}
