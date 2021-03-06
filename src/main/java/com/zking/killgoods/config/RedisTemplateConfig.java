package com.zking.killgoods.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisTemplateConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
      RedisTemplate<String,Object> redisTemplate=new RedisTemplate();
      //定义redis的工厂类
      redisTemplate.setConnectionFactory(redisConnectionFactory);
      //定义redis的字符串键位值模式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //定义redis的字符串值位模式
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        //定义redis的hash键位模式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //定义redishash值位模式
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
       //刷新redis模板
        redisTemplate.afterPropertiesSet();
      return redisTemplate;
    }
}
