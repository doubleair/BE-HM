package service;

import java.util.List;

import common.PageList;
import model.MarkModel;
import param.MarkParam;

/**
 * ��MarkService.java��ʵ���������ۼ�service
 * 
 * @author jizhi.qy 2017��11��20�� ����8:59:58
 */
public interface MarkService {
    /**
     * ���ºۼ�
     * 
     * @param model
     * @return
     */
    Boolean update(MarkModel model);

    /**
     * �����ۼ�
     * 
     * @param model
     * @return
     */
    Integer create(MarkModel model);

    /**
     * �޷�ҳ��ѯ�ۼ�
     * 
     * @param param
     * @return
     */
    List<MarkModel> queryWithoutPage(MarkParam param);

    /**
     * �з�ҳ��ѯ�ۼ�
     * 
     * @param param
     * @return
     */
    PageList<MarkModel> query(MarkParam param);
}
