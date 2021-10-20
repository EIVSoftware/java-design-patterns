package com.eiv.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisListenerCfg {

    @Bean
    public RedisMessageListenerContainer listenerContainer(
            MessageListenerAdapter listenerAdapter,
            RedisConnectionFactory connectionFactory) {
        
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(RedisProducer.TOPIC_NAME));
        return container;
    }
    
    @Bean
    public MessageListenerAdapter listenerAdapter(RedisConsumer consumer) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(consumer);
        messageListenerAdapter.setSerializer(new Jackson2JsonRedisSerializer<>(RedisMessage.class));
        return messageListenerAdapter;
    }
    
    /*
    @Bean
    RedisTemplate<String, Student> redisTemplate(RedisConnectionFactory connectionFactory,
            Jackson2JsonRedisSerializer<Student> serializer) {
        RedisTemplate<String, Student> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setDefaultSerializer(serializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    
    @Bean
    public Jackson2JsonRedisSerializer<Student> jackson2JsonRedisSerializer() {
        return new Jackson2JsonRedisSerializer<>(Student.class);
    }
    */
}
