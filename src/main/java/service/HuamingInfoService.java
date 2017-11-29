package service;

import model.HuamingInfoModel;

/**
 * 类HuamingInfoService.java的实现描述：花名service
 * 
 * @author jizhi.qy 2017年11月19日 上午12:51:40
 */
public interface HuamingInfoService {
    HuamingInfoModel getHuamingModelById(Long id);

    HuamingInfoModel getHuamingModelByOpenId(String openId);

    Boolean update(HuamingInfoModel model);

    Integer create(HuamingInfoModel model);
}
