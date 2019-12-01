package com.jstructure.twisub.twitterclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("app.twitter")
@Data
public class AppConfigProperties {

    private String consumerKey;

    private String consumerSecret;

    private String accessToken;

    private String accessTokenSecret;

    private int tweetsPerSearch;

}
