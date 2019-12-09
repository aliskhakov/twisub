package com.jstructure.twisub.tweetsgetter.service;

import com.jstructure.twisub.tweetsgetter.dto.QueryDto;
import com.jstructure.twisub.tweetsgetter.dto.TweetDto;

import java.util.List;
import java.util.UUID;

public interface TweetsService {

    List<QueryDto> getQueries();

    void createTweets(String username, UUID queryId, List<TweetDto> tweets);

    void updateQuery(QueryDto query);

}
