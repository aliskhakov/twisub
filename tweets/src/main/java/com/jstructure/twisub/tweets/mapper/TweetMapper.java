package com.jstructure.twisub.tweets.mapper;

import com.jstructure.twisub.tweets.entity.TweetEntity;
import com.jstructure.twisub.tweets.dto.TweetDto;
import org.springframework.stereotype.Component;

@Component
public class TweetMapper {

    public TweetDto map(TweetEntity tweet) {
        TweetDto dto = new TweetDto();
        dto.setId(tweet.getTwitterId());
        dto.setCreatedAt(tweet.getCreatedAt());
        dto.setAuthor(tweet.getAuthor());
        dto.setMessage(tweet.getMessage());
        return dto;
    }

}
