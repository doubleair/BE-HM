package dataObject;

/**
 * ��HuamingInfoDO.java��ʵ������������DO
 * 
 * @author jizhi.qy 2017��11��19�� ����2:43:40
 */
public class HuamingInfoDO extends AbstractDO {

    private String huaming;

    private String introduction;

    private Long userCenterId;

    private String openId;

    public String getHuaming() {
        return huaming;
    }

    public void setHuaming(String huaming) {
        this.huaming = huaming;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getUserCenterId() {
        return userCenterId;
    }

    public void setUserCenterId(Long userCenterId) {
        this.userCenterId = userCenterId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

}
