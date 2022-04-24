package com.zking.killgoods.service;

import com.zking.killgoods.model.User;

public interface IRedisService {

    public void setRedis(String token,User user);

    User getRedis(String token);
}
