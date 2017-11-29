package param;

import java.util.Map;

/**
 * ��MarkConstantParam.java��ʵ���������ۼ�������Ŀ�б�param
 * 
 * @author jizhi.qy 2017��11��27�� ����9:25:59
 */
public class MarkConstantParam extends AbstractParam {

    /**
     * ��Ŀ
     */
    private String category;

    /**
     * ������
     */
    private String cnName;

    /**
     * Ӣ����
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
