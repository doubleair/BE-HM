package service.serviceImpl;

import java.util.List;

import dao.AbstractDAO;
import dao.UserCenterDAO;
import dataObject.UserCenterDO;
import mapper.Mapper;
import mapper.UserCenterMapper;
import model.UserCenterModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import param.UserCenterParam;
import service.DefaultService;
import service.UserCenterService;

/**
 * 类UserLoginServiceImpl.java的实现描述：用户中心信息service实现类
 * 
 * @author jizhi.qy 2017年11月11日 上午10:38:45
 */
@Service
public class UserCenterServiceImpl extends DefaultService<UserCenterModel, UserCenterDO, UserCenterParam>
    implements UserCenterService {

    private static final Log Log = LogFactory.getLog(UserCenterServiceImpl.class);

    @Autowired
    private UserCenterDAO userCenterDAO;
    @Autowired
    private UserCenterMapper userCenterMapper;

    @Override
    public int login(UserCenterModel model) {
        Integer res = 0;
        try {
            UserCenterDO userCenterDO = userCenterMapper.toDO(model);
            res = userCenterDAO.insert(userCenterDO);
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return res;
    }

    @Override
    public AbstractDAO<UserCenterDO, UserCenterParam> getDao() {
        return userCenterDAO;
    }

    @Override
    public Mapper<UserCenterModel, UserCenterDO> getMapper() {
        return userCenterMapper;
    }

    @Override
    public UserCenterModel getUserCenterById(Long id) {
        return this.find(id);
    }

    @Override
    public UserCenterModel getUserCenterByOpenId(String openId) {
        UserCenterParam param = new UserCenterParam();
        param.setOpenId(openId);
        List<UserCenterDO> doList = getDao().query(param);
        if (null != doList && doList.size() > 0) {
            return getMapper().toModel(doList.get(0));
        }
        return null;
    }

}
