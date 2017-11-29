package model;

/**
 * ��AuthTokenModel.java��ʵ��������΢�ŷ�����Ȩmodel
 * 
 * @author jizhi.qy 2017��11��8�� ����11:32:38
 */
public class AuthTokenModel {
    /**
     * ����token
     */
    private String access_token;

    /**
     * ����ʱ��
     */
    private Long expires_in;

    /**
     * session
     */
    private String session_key;

    /**
     * �û�openId
     */
    private String openid;

    /**
     * unionId
     */
    private String unionid;

    /**
     * sessionKey(��ʱû�õ�)
     */
    private String sessionKey;

    /**
     * ������
     */
    private Long errcode;

    /**
     * ������Ϣ
     */
    private String errmsg;

    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getUnionid() {
        return unionid;
    }
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getSessionKey() {
        if (null == sessionKey) {
            return getSession_key();
        }
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
    public Long getErrcode() {
        return errcode;
    }
    public void setErrcode(Long errcode) {
        this.errcode = errcode;
    }
    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

}
