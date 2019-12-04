package com.jstructure.twisub.twitterclient.config;

import com.jstructure.twisub.twitterclient.TwitterclientApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@EnableConfigurationProperties(AppConfigProperties.class)
@RequiredArgsConstructor
@EnableSwagger2
public class AppConfig {

    private final TwitterTemplateFactory twitterTemplateFactory;

    @Bean
    public Twitter twitterTemplate() throws Exception {
        return twitterTemplateFactory.getObject();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(TwitterclientApplication.class.getPackage().getName()))
                .paths(any())
                .build();
    }

}
