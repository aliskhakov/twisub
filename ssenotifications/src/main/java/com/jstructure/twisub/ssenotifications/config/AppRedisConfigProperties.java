package com.jstructure.twisub.ssenotifications.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("app.redis")
public class AppRedisConfigProperties {

    private String host;

    private int port;

    private String password;

}
