package model;
/**
 * ��UserLoginModel.java��ʵ���������û�����model
 * 
 * @author jizhi.qy 2017��11��11�� ����10:47:31
 */
public class UserCenterModel extends AbstractModel {

    /**
     * �û���
     */
    private String nickName;

    /**
     * �Ա� 0 1
     */
    private Integer gender;

    /**
     * ����
     */
    private String city;

    /**
     * ʡ
     */
    private String province;

    /**
     * ����
     */
    private String country;

    /**
     * ͷ��url
     */
    private String avatarUrl;

    /**
     * openId
     */
    private String openId;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }


}
