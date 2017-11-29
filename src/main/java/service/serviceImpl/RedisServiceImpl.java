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
 * ��RedisServiceImpl.java��ʵ��������redis serviceʵ����
 * 
 * @author jizhi.qy 2017��11��9�� ����3:10:45
 */
@Service
public class RedisServiceImpl implements RedisService {

    private static final Log Log = LogFactory.getLog(RedisServiceImpl.class);

    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;

    /**
     * ����ɾ����Ӧ��value
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
     * ����ɾ��key
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
     * ɾ����Ӧ��value
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
     * �жϻ������Ƿ��ж�Ӧ��value
     * 
     * @param key
     * @return
     */
    @Override
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * ��ȡ����
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
     * д�뻺��
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
     * д�뻺��
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
        // ���ݴ���session��Ϣ��ѯredis����ȡ�û���Ϣ�����redisû�У���˵��session���󣬷��ش������µ�¼
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
