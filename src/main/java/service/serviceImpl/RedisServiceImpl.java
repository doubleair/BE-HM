package service.serviceImpl;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;

import model.UserCenterModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import service.RedisService;

/**
 * 类RedisServiceImpl.java的实现描述：redis service实现类
 * 
 * @author jizhi.qy 2017年11月9日 下午3:10:45
 */
@Service
public class RedisServiceImpl implements RedisService {

    private static final Log Log = LogFactory.getLog(RedisServiceImpl.class);

    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;

    /**
     * 批量删除对应的value
     * 
     * @param keys
     */
    @Override
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * 
     * @param pattern
     */
    @Override
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     * 
     * @param key
     */
    @Override
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     * 
     * @param key
     * @return
     */
    @Override
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     * 
     * @param key
     * @return
     */
    @Override
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存
     * 
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            Log.error("set cache error", e);
        }
        return result;
    }

    /**
     * 写入缓存
     * 
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            Log.error("set cache error", e);
        }
        return result;
    }

    @Override
    public long increment(final String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public UserCenterModel checkUserSession(String wxLocalSessionId) {
        UserCenterModel userCenterModel = null;
        // 根据传入session信息查询redis，获取用户信息，如果redis没有，就说明session错误，返回错误，重新登录
        try {
            String redisMapJson = (String)get(wxLocalSessionId);
            if (StringUtils.isBlank(redisMapJson)) {
                return null;
            }
            Map<String, String> redisMap = JSONObject.parseObject(redisMapJson, java.util.Map.class);
            if (StringUtils.isBlank(redisMap.get("userCenterModel"))) {
                return null;
            }

            userCenterModel = JSONObject.parseObject(redisMap.get("userCenterModel"), UserCenterModel.class);
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return userCenterModel;
    }

    @Override
    public Map<String, String> getRedisMap(String wxLocalSessionId) {
        if (StringUtils.isBlank(wxLocalSessionId)) {
            return null;
        }
        try {
            String redisMapJson = (String)get(wxLocalSessionId);
            if (StringUtils.isBlank(redisMapJson)) {
                return null;
            }
            Map<String, String> redisMap = JSONObject.parseObject(redisMapJson, Map.class);
            return redisMap;
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        return null;
    }
}
