package com.jstructure.twisub.tweets.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("app.twitter")
@Data
public class TwitterConfigProperties {

    private boolean useMock;

    private String consumerKey;

    private String consumerSecret;

    private String accessToken;

    private String accessTokenSecret;

    private int tweetsPerSearch = 10;

}
