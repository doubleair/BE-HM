package model;

import java.util.List;

/**
 * ��HuamingInfoModel.java��ʵ��������������Ϣmodel
 * 
 * @author jizhi.qy 2017��11��18�� ����11:37:25
 */
public class HuamingInfoModel extends AbstractModel {
    /**
     * ��������
     */
    private String huaming;

    /**
     * ��˵
     */
    private String introduction;

    /**
     * openId
     */
    private String openId;

    /**
     * �û�����id
     */
    private Long userCenterId;

    /**
     * ����
     */
    private List<JianghuModel> jianghuModelList;

    /**
     * �ۼ�
     */
    private List<MarkModel> markModelList;

    public String getHuaming() {
        return huaming;
    }

    public void setHuaming(String huaming) {
        this.huaming = huaming;
        this.addChange("huaming");
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
        this.addChange("introduction");
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
        this.addChange("openId");
    }

    public Long getUserCenterId() {
        return userCenterId;
    }

    public void setUserCenterId(Long userCenterId) {
        this.userCenterId = userCenterId;
        this.addChange("userCenterId");
    }

    public List<JianghuModel> getJianghuModelList() {
        return jianghuModelList;
    }

    public void setJianghuModelList(List<JianghuModel> jianghuModelList) {
        this.jianghuModelList = jianghuModelList;
        this.addChange("jianghuModelList");
    }

    public List<MarkModel> getMarkModelList() {
        return markModelList;
    }

    public void setMarkModelList(List<MarkModel> markModelList) {
        this.markModelList = markModelList;
        this.addChange("markModelList");
    }

}
