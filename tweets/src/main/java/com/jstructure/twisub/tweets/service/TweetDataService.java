package com.jstructure.twisub.tweets.service;

import com.jstructure.twisub.tweets.dto.TweetDto;

import java.util.UUID;

public interface TweetDataService {

    void createTweet(UUID queryId, TweetDto tweetDto);

    void createTweets(String username, UUID queryId, Iterable<TweetDto> tweets);

    @Deprecated
    Iterable<TweetDto> getAll(String username, UUID queryId);

}
