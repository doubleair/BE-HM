package dataObject;
/**
 * 类JianghuDO.java的实现描述：江湖DO
 * 
 * @author jizhi.qy 2017年11月21日 上午12:41:40
 */
public class JianghuDO extends AbstractDO {
    /**
     * JianghuConstant的id
     */
    private Integer typeId;

    /**
     * 中文名
     */
    private String cnName;

    /**
     * 站点连接等
     */
    private String site;

    /**
     * 主页等描述
     */
    private String description;

    /**
     * openId
     */
    private String openId;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
