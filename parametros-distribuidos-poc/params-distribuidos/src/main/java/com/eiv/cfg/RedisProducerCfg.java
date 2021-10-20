package com.eiv.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisProducerCfg {

    @Bean
    public RedisTemplate<String, RedisMessage> redisTemplate(
            RedisConnectionFactory connectionFactory,
            Jackson2JsonRedisSerializer<RedisMessage> serializer) {
        
        RedisTemplate<String, RedisMessage> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setDefaultSerializer(serializer);
        redisTemplate.afterPropertiesSet();
        
        return redisTemplate;
    }
    
    @Bean
    public Jackson2JsonRedisSerializer<RedisMessage> jackson2JsonRedisSerializer() {
        return new Jackson2JsonRedisSerializer<>(RedisMessage.class);
    }
}
