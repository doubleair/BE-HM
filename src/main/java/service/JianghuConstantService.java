package service;

import common.PageList;
import model.JianghuConstantModel;
import param.JianghuConstantParam;

/**
 * 类MarkConstantService.java的实现描述：足迹常量服务接口
 * 
 * @author jizhi.qy 2017年11月27日 下午9:20:57
 */
public interface JianghuConstantService {
    /**
     * 有分页查询痕迹
     * 
     * @param param
     * @return
     */
    PageList<JianghuConstantModel> query(JianghuConstantParam param);
}
