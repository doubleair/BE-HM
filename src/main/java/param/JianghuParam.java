package param;

import java.util.Map;

/**
 * ��JianghuParam.java��ʵ������������param
 * 
 * @author jizhi.qy 2017��11��21�� ����12:40:20
 */
public class JianghuParam extends AbstractParam {
    /**
     * id
     */
    private Long id;

    /**
     * JianghuConstant��id
     */
    private Integer typeId;

    /**
     * ������
     */
    private String cnName;

    /**
     * openId
     */
    private String openId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    protected void addParams(Map<String, Object> existParam) {
        existParam.put("id", id);
        existParam.put("typeId", typeId);
        existParam.put("openId", openId);
        existParam.put("cnName", cnName);
    }

}
