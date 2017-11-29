package param;

import java.util.Map;

/**
 * 类MarkParam.java的实现描述：痕迹param
 * 
 * @author jizhi.qy 2017年11月21日 上午12:24:09
 */
public class MarkParam extends AbstractParam {

    /**
     * id
     */
    private Long id;

    /**
     * 类型
     */
    private Integer typeId;

    /**
     * openId
     */
    private String openId;

    /**
     * 中文名
     */
    private String cnName;

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
        existParam.put("cnName", cnName);
        existParam.put("openId", openId);
    }
}
