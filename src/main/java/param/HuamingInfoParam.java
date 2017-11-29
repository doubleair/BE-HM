package param;

import java.util.Date;
import java.util.Map;

/**
 * 类HuamingInfoParam.java的实现描述：花名param
 * 
 * @author jizhi.qy 2017年11月19日 上午1:41:37
 */
public class HuamingInfoParam extends AbstractParam {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtUpdate;

    /**
     * 花名
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
     * userCenterId
     */
    private Long userCenterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getUserCenterId() {
        return userCenterId;
    }

    public void setUserCenterId(Long userCenterId) {
        this.userCenterId = userCenterId;
    }

    @Override
    protected void addParams(Map<String, Object> existParam) {
        existParam.put("id", id);
        existParam.put("huaming", huaming);
        existParam.put("introduction", introduction);
        existParam.put("openId", openId);
        existParam.put("userCenterId", userCenterId);
    }
}
