package service;

import common.PageList;
import model.MarkConstantModel;
import param.MarkConstantParam;

/**
 * ��MarkConstantService.java��ʵ���������㼣��������ӿ�
 * 
 * @author jizhi.qy 2017��11��27�� ����9:20:57
 */
public interface MarkConstantService {
    /**
     * �з�ҳ��ѯ�ۼ�
     * 
     * @param param
     * @return
     */
    PageList<MarkConstantModel> query(MarkConstantParam param);
}
