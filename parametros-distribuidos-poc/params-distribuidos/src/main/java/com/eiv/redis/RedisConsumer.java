package com.eiv.redis;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RedisConsumer {

    public void handleMessage(RedisMessage message) {
        log.info("Message: {}", message.getText());
    }
}
