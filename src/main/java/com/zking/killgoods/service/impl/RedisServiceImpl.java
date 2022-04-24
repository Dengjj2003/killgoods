package com.zking.killgoods.service.impl;

import com.zking.killgoods.model.User;
import com.zking.killgoods.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void setRedis(String token, User user) {
        redisTemplate.opsForValue().set("user:"+token,user,7200, TimeUnit.SECONDS);
    }

    @Override
    public User getRedis(String token) {
        return (User)redisTemplate.opsForValue().get("user:"+token);
    }
}
