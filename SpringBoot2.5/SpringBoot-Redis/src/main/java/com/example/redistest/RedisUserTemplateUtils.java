package com.example.redistest;

import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author why
 * @date 2021/10/28 11:31
 * @PackageName com.example.redistest
 * @description
 */
@Component
public class RedisUserTemplateUtils {
    //@Autowired
    private RedisTemplate<Object, User> redisTemplate;

    public void setObject(String key,User value,Long timeOut){
        // redisTemplate.opsForValue().set(key,value,timeOut,TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(key,value);
        if (timeOut != null) {
            //设置key的过期时间
            redisTemplate.expire(key,timeOut, TimeUnit.SECONDS);
        }


    }
    public User getObject(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
