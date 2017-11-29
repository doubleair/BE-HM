package service;

import model.HuamingInfoModel;

/**
 * ��HuamingInfoService.java��ʵ������������service
 * 
 * @author jizhi.qy 2017��11��19�� ����12:51:40
 */
public interface HuamingInfoService {
    HuamingInfoModel getHuamingModelById(Long id);

    HuamingInfoModel getHuamingModelByOpenId(String openId);

    Boolean update(HuamingInfoModel model);

    Integer create(HuamingInfoModel model);
}
