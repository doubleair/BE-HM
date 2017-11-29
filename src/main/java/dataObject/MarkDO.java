package dataObject;

/**
 * 类MarkDO.java的实现描述：痕迹DO
 * 
 * @author jizhi.qy 2017年11月21日 上午12:23:46
 */
public class MarkDO extends AbstractDO {
    /**
     * type '类别：movie等'
     */
    private Integer typeId;

    /**
     * 中文名
     */
    private String cnName;

    /**
     * 描述
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

}
