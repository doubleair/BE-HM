package model;

/**
 * 类JianghuModel.java的实现描述：江湖模型
 * 
 * @author jizhi.qy 2017年11月19日 上午12:12:02
 */
public class JianghuModel extends AbstractModel {
    /**
     * JianghuConstant的id
     */
    private Integer typeId;

    /**
     * 中文名
     */
    private String cnName;

    /**
     * 站点信息等内容
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
