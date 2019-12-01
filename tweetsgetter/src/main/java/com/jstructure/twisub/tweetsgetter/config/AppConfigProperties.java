package com.jstructure.twisub.tweetsgetter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("app")
public class AppConfigProperties {

    private String twitterClientUrl;

    private String tweetsUrl;

    private Long getTweetsPeriodicity;

}
