package service;

import java.util.Map;

import model.UserCenterModel;

/**
 * 类RedisService.java的实现描述：redis service
 * 
 * @author jizhi.qy 2017年11月9日 下午3:09:52
 */
public interface RedisService {
    /**
     * 批量删除对应的value
     * 
     * @param keys
     */
    public void remove(final String... keys);

    /**
     * 批量删除key
     * 
     * @param pattern
     */
    public void removePattern(final String pattern);

    /**
     * 删除对应的value
     * 
     * @param key
     */
    public void remove(final String key);

    /**
     * 判断缓存中是否有对应的value
     * 
     * @param key
     * @return
     */
    public boolean exists(final String key);

    /**
     * 读取缓存
     * 
     * @param key
     * @return
     */
    public Object get(final String key);

    /**
     * 写入缓存
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value);

    /**
     * 写入缓存
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime);

    /**
     * 自增
     * 
     * @param key
     * @param delta
     * @return
     */
    public long increment(final String key, long delta);

    /**
     * 根据本地wxLocalSessionId获取对应的value
     * 
     * @param wxLocalSessionId
     * @return
     */
    public UserCenterModel checkUserSession(String wxLocalSessionId);

    /**
     * 根据本地wxLocalSessionId获取redis中的缓存map
     * 
     * @param wxLocalSessionId
     * @return
     */
    public Map<String, String> getRedisMap(String wxLocalSessionId);
}
