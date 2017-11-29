package service;

import java.util.List;

import common.PageList;
import model.JianghuModel;
import param.JianghuParam;

/**
 * 类JianghuService.java的实现描述：江湖service
 * 
 * @author jizhi.qy 2017年11月20日 下午8:59:48
 */
public interface JianghuService {
    /**
     * 根据id查询江湖信息
     * 
     * @return
     */
    JianghuModel getJianghuModelById();

    /**
     * 根据openId查询江湖信息
     * 
     * @return
     */
    JianghuModel getJianghuModelByOpenId();

    /**
     * 创建江湖信息
     * 
     * @param jianghuModel
     * @return
     */
    Integer create(JianghuModel jianghuModel);

    /**
     * 根据id更新江湖信息
     * 
     * @param jianghuModel
     * @return
     */
    Boolean update(JianghuModel jianghuModel);

    /**
     * 分页查询
     * 
     * @param param
     * @return
     */
    PageList<JianghuModel> query(JianghuParam param);

    /**
     * 不分页查询
     * 
     * @param param
     * @return
     */
    List<JianghuModel> queryWithoutPage(JianghuParam param);
}
