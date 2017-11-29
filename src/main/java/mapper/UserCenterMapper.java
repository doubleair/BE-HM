package mapper;

import dataObject.UserCenterDO;
import model.UserCenterModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

/**
 * ��UserCenterMapper.java��ʵ��������TODO ��ʵ������ 
 * @author jizhi.qy 2017��11��12�� ����10:24:03
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
