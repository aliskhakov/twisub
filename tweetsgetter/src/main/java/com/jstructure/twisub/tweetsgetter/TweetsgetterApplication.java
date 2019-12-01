package com.jstructure.twisub.tweetsgetter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class TweetsgetterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetsgetterApplication.class, args);
	}

}
