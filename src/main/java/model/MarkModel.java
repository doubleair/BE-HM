package model;

/**
 * 类MarkModel.java的实现描述：痕迹模型
 * 
 * @author jizhi.qy 2017年11月20日 下午8:57:18
 */
public class MarkModel extends AbstractModel {
    /**
     * 种类id，对应markConstant库中的id
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
