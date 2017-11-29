/**
 * 类RPCResult.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月8日 下午10:48:45
 */

package common;

import java.util.HashMap;

public class RPCResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 7178376643774528740L;

    // 参数错误
    public static final int CODE_PARAM_ERROR = 400;

    // 服务错误
    public static final int CODE_SERVER_ERROR = 500;

    // sessionId过期
    public static final int CODE_SESSION_EXPIRE = 440;

    // 参数错误文字
    public static final String MSG_PARAM_ERROR = "param error";

    // 服务错误文字
    public static final String MSG_SERVER_ERROR = "param error";

    // sessionId过期
    public static final String MSG_SESSION_EXPIRE = "session expire";

    public static RPCResult error(int errorCode, String errorMessage) {
        RPCResult result = new RPCResult();
        return result.setSuccess(false).setErrorCode(errorCode).setErrorMsg(errorMessage);
    }

    public RPCResult setSuccess(boolean success) {
        this.put("success", success);
        return this;
    }

    public RPCResult setErrorCode(int errorCode) {
        this.put("errorCode", errorCode);
        return this;
    }

    public RPCResult setErrorMsg(String errorCode) {
        this.put("errorMsg", errorCode);
        return this;
    }

    public static RPCResult ok(Object obj) {
        return RPCResult.ok("data", obj);
    }

    public static RPCResult ok(String key, Object data) {
        RPCResult result = new RPCResult();
        result.setSuccess(true).addData(key, data);
        return result;
    }

    public RPCResult addData(String key, Object data) {
        this.put(key, data);
        return this;
    }

    public static RPCResult ok() {
        RPCResult result = new RPCResult();
        result.setSuccess(true);
        return result;
    }
}
