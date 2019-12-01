package com.jstructure.twisub.twitterclient.mapper;

import com.jstructure.twisub.twitterclient.dto.TweetDto;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

@Component
public class TweetMapper {

    public TweetDto map(Tweet tweet) {
        TweetDto dto = new TweetDto();
        dto.setId(tweet.getId());
        dto.setCreatedAt(tweet.getCreatedAt());
        dto.setAuthor(tweet.getFromUser());
        dto.setMessage(tweet.getText());
        return dto;
    }

}
