package mapper;

import dataObject.UserCenterDO;
import model.UserCenterModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

/**
 * 类UserCenterMapper.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月12日 下午10:24:03
 */
@Repository
public class UserCenterMapper implements Mapper<UserCenterModel, UserCenterDO> {

    @Override
    public UserCenterDO toDO(UserCenterModel m) {
        UserCenterDO userCenterDO = new UserCenterDO();
        BeanUtils.copyProperties(m, userCenterDO);
        return userCenterDO;
    }

    @Override
    public UserCenterModel toModel(UserCenterDO d) {
        UserCenterModel ucModel = new UserCenterModel();
        BeanUtils.copyProperties(d, ucModel);
        return ucModel;
    }

}
