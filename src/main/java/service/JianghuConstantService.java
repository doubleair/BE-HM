package service;

import common.PageList;
import model.JianghuConstantModel;
import param.JianghuConstantParam;

/**
 * ��MarkConstantService.java��ʵ���������㼣��������ӿ�
 * 
 * @author jizhi.qy 2017��11��27�� ����9:20:57
 */
public interface JianghuConstantService {
    /**
     * �з�ҳ��ѯ�ۼ�
     * 
     * @param param
     * @return
     */
    PageList<JianghuConstantModel> query(JianghuConstantParam param);
}
