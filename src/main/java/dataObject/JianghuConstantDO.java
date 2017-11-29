package dataObject;
/**
 * 类MarkConstantDO.java的实现描述：江湖常量类目列表DO
 * 
 * @author jizhi.qy 2017年11月27日 下午9:29:00
 */
public class JianghuConstantDO extends AbstractDO {
    private String category;

    private String cnName;

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
}
