package com.xmb.workout.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class XRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    public void saveString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void saveStringDelay(String key, String value, long delay) {
        redisTemplate.opsForValue().set(key, value, delay, TimeUnit.SECONDS);
    }
    public String getString(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        if (o == null) {
            return "";
        } else {
            return String.valueOf(o);
        }
    }

    public void saveObjectDelay(String key, Object value, long delay) {
        if (value != null) {
            String jsonString = JSON.toJSONString(value);
            saveStringDelay(key, jsonString, delay);
        }
    }

    public <T> T getObject(String key, Class<T> clazz) {
        Object o = redisTemplate.opsForValue().get(key);
        if (o == null) {
            return null;
        } else {
            String jsonString = String.valueOf(o);
            return JSON.parseObject(jsonString, clazz);
        }
    }

}
