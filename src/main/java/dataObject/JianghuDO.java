package dataObject;
/**
 * ��JianghuDO.java��ʵ������������DO
 * 
 * @author jizhi.qy 2017��11��21�� ����12:41:40
 */
public class JianghuDO extends AbstractDO {
    /**
     * JianghuConstant��id
     */
    private Integer typeId;

    /**
     * ������
     */
    private String cnName;

    /**
     * վ�����ӵ�
     */
    private String site;

    /**
     * ��ҳ������
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
