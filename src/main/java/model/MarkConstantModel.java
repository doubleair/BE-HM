package model;

/**
 * 类MarkConstantModel.java的实现描述：足迹的列表，是固定取值，非用户信息，用于前端获取
 * 
 * @author jizhi.qy 2017年11月27日 下午9:02:38
 */
public class MarkConstantModel extends AbstractModel {

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
