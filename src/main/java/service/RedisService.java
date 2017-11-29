package service;

import java.util.Map;

import model.UserCenterModel;

/**
 * ��RedisService.java��ʵ��������redis service
 * 
 * @author jizhi.qy 2017��11��9�� ����3:09:52
 */
public interface RedisService {
    /**
     * ����ɾ����Ӧ��value
     * 
     * @param keys
     */
    public void remove(final String... keys);

    /**
     * ����ɾ��key
     * 
     * @param pattern
     */
    public void removePattern(final String pattern);

    /**
     * ɾ����Ӧ��value
     * 
     * @param key
     */
    public void remove(final String key);

    /**
     * �жϻ������Ƿ��ж�Ӧ��value
     * 
     * @param key
     * @return
     */
    public boolean exists(final String key);

    /**
     * ��ȡ����
     * 
     * @param key
     * @return
     */
    public Object get(final String key);

    /**
     * д�뻺��
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value);

    /**
     * д�뻺��
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime);

    /**
     * ����
     * 
     * @param key
     * @param delta
     * @return
     */
    public long increment(final String key, long delta);

    /**
     * ���ݱ���wxLocalSessionId��ȡ��Ӧ��value
     * 
     * @param wxLocalSessionId
     * @return
     */
    public UserCenterModel checkUserSession(String wxLocalSessionId);

    /**
     * ���ݱ���wxLocalSessionId��ȡredis�еĻ���map
     * 
     * @param wxLocalSessionId
     * @return
     */
    public Map<String, String> getRedisMap(String wxLocalSessionId);
}
