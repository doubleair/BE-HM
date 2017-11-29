package param;

import java.util.HashMap;
import java.util.Map;

/**
 * 类AbstractParam.java的实现描述：抽象param
 * 
 * @author jizhi.qy 2017年11月11日 上午11:03:49
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
