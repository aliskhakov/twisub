package com.jstructure.twisub.webapp.service;

import com.jstructure.twisub.webapp.dto.QueryDto;
import com.jstructure.twisub.webapp.dto.TweetDto;

import java.util.List;
import java.util.UUID;

public interface TweetsService {

    List<QueryDto> getQueries();

    List<TweetDto> getTweets(UUID queryId);

    void createQuery(QueryDto query);

}
