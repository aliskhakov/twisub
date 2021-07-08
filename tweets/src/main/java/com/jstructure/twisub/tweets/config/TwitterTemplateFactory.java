package com.jstructure.twisub.tweets.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

@Component
public class TwitterTemplateFactory extends AbstractFactoryBean<Twitter> {

    @Autowired
    private TwitterConfigProperties properties;

    @Override
    public Class<?> getObjectType() {
        return Twitter.class;
    }

    @Override
    protected Twitter createInstance() {
        if (properties.isUseMock()) {
            return null;
        }
        return new TwitterTemplate(
                properties.getConsumerKey(),
                properties.getConsumerSecret(),
                properties.getAccessToken(),
                properties.getAccessTokenSecret()
        );
    }

}
