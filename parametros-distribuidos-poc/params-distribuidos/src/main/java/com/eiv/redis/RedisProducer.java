package com.eiv.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisProducer {

    public static final String TOPIC_NAME = "paramsTopic";
    
    private final RedisTemplate<String, RedisMessage> redisTemplate;
    
    public void send(String message) { 
        RedisMessage rm = new RedisMessage();
        rm.setText(message);
        redisTemplate.convertAndSend(TOPIC_NAME, rm);
    }
}
