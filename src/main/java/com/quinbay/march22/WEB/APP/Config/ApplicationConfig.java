package com.quinbay.march22.WEB.APP.Config;

import com.quinbay.march22.WEB.APP.dto.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class ApplicationConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisconfactory = new JedisConnectionFactory();
        jedisconfactory.setHostName("localhost");
        jedisconfactory.setPort(6379);
        return jedisconfactory;

    }
    @Bean

    public RedisTemplate<String,Student> redisTemplate()
    {
        RedisTemplate<String,Student> template =new RedisTemplate<String,Student>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        return  template;
    }
}
