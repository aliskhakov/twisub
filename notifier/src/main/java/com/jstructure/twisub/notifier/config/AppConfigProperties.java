package com.jstructure.twisub.notifier.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("app")
public class AppConfigProperties {

    private String emailSenderUrl;

    private String usersUrl;

}
