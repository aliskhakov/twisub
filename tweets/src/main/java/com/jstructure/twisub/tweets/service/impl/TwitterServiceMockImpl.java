package com.jstructure.twisub.tweets.service.impl;

import com.jstructure.twisub.tweets.config.TwitterConfigProperties;
import com.jstructure.twisub.tweets.dto.TweetDto;
import com.jstructure.twisub.tweets.service.TwitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TwitterServiceMockImpl implements TwitterService {

    private static final String TWEET_FORMAT = "This is a test tweet for query '%s'. " +
            "If you want to see real tweets set up Twitter API credentials.";

    private static final String TWEET_AUTHOR = "testuser";

    private final TwitterConfigProperties properties;

    @Override
    public List<TweetDto> search(String query) {
        List<TweetDto> tweets = new ArrayList<>();
        for (int i = 0; i < properties.getTweetsPerSearch(); i++) {
            TweetDto tweet = new TweetDto();
            tweet.setAuthor(TWEET_AUTHOR);
            tweet.setCreatedAt(new Date());
            tweet.setId(System.currentTimeMillis() + i);
            tweet.setMessage(String.format(TWEET_FORMAT, query));
            tweets.add(tweet);
        }
        return tweets;
    }

    @Override
    public List<TweetDto> search(String query, Long sinceId) {
        return search(query);
    }

}
