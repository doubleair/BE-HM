package service;

import java.util.List;

import common.PageList;
import model.JianghuModel;
import param.JianghuParam;

/**
 * ��JianghuService.java��ʵ������������service
 * 
 * @author jizhi.qy 2017��11��20�� ����8:59:48
 */
public interface JianghuService {
    /**
     * ����id��ѯ������Ϣ
     * 
     * @return
     */
    JianghuModel getJianghuModelById();

    /**
     * ����openId��ѯ������Ϣ
     * 
     * @return
     */
    JianghuModel getJianghuModelByOpenId();

    /**
     * ����������Ϣ
     * 
     * @param jianghuModel
     * @return
     */
    Integer create(JianghuModel jianghuModel);

    /**
     * ����id���½�����Ϣ
     * 
     * @param jianghuModel
     * @return
     */
    Boolean update(JianghuModel jianghuModel);

    /**
     * ��ҳ��ѯ
     * 
     * @param param
     * @return
     */
    PageList<JianghuModel> query(JianghuParam param);

    /**
     * ����ҳ��ѯ
     * 
     * @param param
     * @return
     */
    List<JianghuModel> queryWithoutPage(JianghuParam param);
}
