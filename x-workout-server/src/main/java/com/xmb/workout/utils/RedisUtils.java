package com.xmb.workout.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Ben
 * @date 2020-04-23
 * @desc
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    public void save(String key, String value) {

        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {

        Object o = redisTemplate.opsForValue().get(key);
        if (o == null) {

            return "";
        } else {

            return String.valueOf(o);
        }
    }

    public void delete(String key) {

        redisTemplate.delete(key);
    }
}
