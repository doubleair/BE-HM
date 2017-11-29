package param;

import java.util.Map;

/**
 * ��UserCenterParam.java��ʵ���������û�����param
 * 
 * @author jizhi.qy 2017��11��12�� ����10:18:06
 */
public class UserCenterParam extends AbstractParam {

    /**
     * id
     */
    private Long id;

    /**
     * openId
     */
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    protected void addParams(Map<String, Object> existParam) {
        existParam.put("openId", openId);
        existParam.put("id", id);
    }
}
