package com.jstructure.twisub.tweets.mapper;

import com.jstructure.twisub.tweets.entity.TweetEntity;
import com.jstructure.twisub.tweets.dto.TweetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TweetMapper {

    private final QueryMapper queryMapper;

    public TweetDto map(TweetEntity tweet) {
        TweetDto dto = new TweetDto();
        dto.setId(tweet.getTwitterId());
        dto.setCreatedAt(tweet.getCreatedAt());
        dto.setAuthor(tweet.getAuthor());
        dto.setMessage(tweet.getMessage());
        return dto;
    }

    public TweetDto mapWithLinks(TweetEntity tweet) {
        TweetDto dto = map(tweet);
        dto.setQuery(queryMapper.map(tweet.getQuery()));
        return dto;
    }

}
