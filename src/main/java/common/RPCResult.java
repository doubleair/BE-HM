/**
 * ��RPCResult.java��ʵ��������TODO ��ʵ������ 
 * @author jizhi.qy 2017��11��8�� ����10:48:45
 */

package common;

import java.util.HashMap;

public class RPCResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 7178376643774528740L;

    // ��������
    public static final int CODE_PARAM_ERROR = 400;

    // �������
    public static final int CODE_SERVER_ERROR = 500;

    // sessionId����
    public static final int CODE_SESSION_EXPIRE = 440;

    // ������������
    public static final String MSG_PARAM_ERROR = "param error";

    // �����������
    public static final String MSG_SERVER_ERROR = "param error";

    // sessionId����
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
