package com.jstructure.twisub.tweetsgetter.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
@EnableConfigurationProperties(AppConfigProperties.class)
public class AppConfig {

    @Bean
    public RestOperations getRestTemplate() {
        return new RestTemplate();
    }

}
