package dataObject;

/**
 * ��MarkDO.java��ʵ���������ۼ�DO
 * 
 * @author jizhi.qy 2017��11��21�� ����12:23:46
 */
public class MarkDO extends AbstractDO {
    /**
     * type '���movie��'
     */
    private Integer typeId;

    /**
     * ������
     */
    private String cnName;

    /**
     * ����
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
