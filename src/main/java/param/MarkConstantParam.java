package param;

import java.util.Map;

/**
 * 类MarkConstantParam.java的实现描述：痕迹常量类目列表param
 * 
 * @author jizhi.qy 2017年11月27日 下午9:25:59
 */
public class MarkConstantParam extends AbstractParam {

    /**
     * 类目
     */
    private String category;

    /**
     * 中文名
     */
    private String cnName;

    /**
     * 英文名
     */
    private String name;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void addParams(Map<String, Object> existParam) {
        existParam.put("category", category);
        existParam.put("cnName", cnName);
        existParam.put("name", name);
    }

}
