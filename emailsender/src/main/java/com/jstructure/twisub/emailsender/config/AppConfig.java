package com.jstructure.twisub.emailsender.config;

import com.jstructure.twisub.emailsender.EmailSenderApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@RequiredArgsConstructor
@EnableSwagger2
@EnableConfigurationProperties(AppRedisConfigProperties.class)
public class AppConfig {

    private final AppRedisConfigProperties redisProps;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(EmailSenderApplication.class.getPackage().getName()))
                .paths(any())
                .build();
    }

    @Bean
    public Jedis redisTemplate() {
        Jedis redisTemplate = new Jedis(redisProps.getHost(), redisProps.getPort());
        redisTemplate.auth(redisProps.getPassword());
        return redisTemplate;
    }

}
