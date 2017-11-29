package param;

import java.util.HashMap;
import java.util.Map;

/**
 * ��AbstractParam.java��ʵ������������param
 * 
 * @author jizhi.qy 2017��11��11�� ����11:03:49
 */
public abstract class AbstractParam extends PagableParam {
    public Map<String, Object> toParamMap() {
        final Map<String, Object> params = new HashMap<String, Object>();
        if (isPaged()) {
            params.put("startNum", getStartNum());
            params.put("pageSize", getPageSize());
        }
        addParams(params);
        return params;
    }

    protected abstract void addParams(Map<String, Object> existParam);
}
