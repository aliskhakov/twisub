package com.jstructure.twisub.twitterclient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;

@Configuration
@EnableConfigurationProperties(AppConfigProperties.class)
public class AppConfig {

    @Autowired
    private TwitterTemplateFactory twitterTemplateFactory;

    @Bean
    public Twitter twitterTemplate() throws Exception {
        return twitterTemplateFactory.getObject();
    }

}
