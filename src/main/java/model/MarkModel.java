package model;

/**
 * ��MarkModel.java��ʵ���������ۼ�ģ��
 * 
 * @author jizhi.qy 2017��11��20�� ����8:57:18
 */
public class MarkModel extends AbstractModel {
    /**
     * ����id����ӦmarkConstant���е�id
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
