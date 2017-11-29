package service;

import java.util.List;

import common.PageList;
import model.MarkModel;
import param.MarkParam;

/**
 * 类MarkService.java的实现描述：痕迹service
 * 
 * @author jizhi.qy 2017年11月20日 下午8:59:58
 */
public interface MarkService {
    /**
     * 更新痕迹
     * 
     * @param model
     * @return
     */
    Boolean update(MarkModel model);

    /**
     * 创建痕迹
     * 
     * @param model
     * @return
     */
    Integer create(MarkModel model);

    /**
     * 无分页查询痕迹
     * 
     * @param param
     * @return
     */
    List<MarkModel> queryWithoutPage(MarkParam param);

    /**
     * 有分页查询痕迹
     * 
     * @param param
     * @return
     */
    PageList<MarkModel> query(MarkParam param);
}
