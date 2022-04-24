package com.zking.killgoods.controller;

import com.zking.killgoods.model.User;
import com.zking.killgoods.service.IRedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private IRedisService redisService;


    @RequestMapping("/")
    public String index(){
        return "login";
    }


}
