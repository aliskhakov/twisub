package com.jstructure.twisub.webapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("app")
public class AppConfigProperties {

    private String usersUrl;

    private String tweetsUrl;

}
