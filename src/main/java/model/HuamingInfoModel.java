package model;

import java.util.List;

/**
 * 类HuamingInfoModel.java的实现描述：花名信息model
 * 
 * @author jizhi.qy 2017年11月18日 下午11:37:25
 */
public class HuamingInfoModel extends AbstractModel {
    /**
     * 花名名称
     */
    private String huaming;

    /**
     * 简说
     */
    private String introduction;

    /**
     * openId
     */
    private String openId;

    /**
     * 用户中心id
     */
    private Long userCenterId;

    /**
     * 江湖
     */
    private List<JianghuModel> jianghuModelList;

    /**
     * 痕迹
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
