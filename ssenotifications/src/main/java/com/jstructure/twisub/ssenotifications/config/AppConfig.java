package com.jstructure.twisub.ssenotifications.config;

import com.jstructure.twisub.ssenotifications.SsenotificationsApplication;
import com.jstructure.twisub.ssenotifications.dto.NotificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@RequiredArgsConstructor
@EnableSwagger2
public class AppConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SsenotificationsApplication.class.getPackage().getName()))
                .paths(any())
                .build();
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
//        jedisConFactory.setHostName("192.168.99.101");
//        jedisConFactory.setPort(6379);
//        jedisConFactory.setPassword("password");
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, NotificationDto> redisTemplate() {
        final RedisTemplate<String, NotificationDto> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<>(NotificationDto.class));
        return template;
    }

}
