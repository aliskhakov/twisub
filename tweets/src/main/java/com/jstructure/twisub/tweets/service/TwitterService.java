package com.jstructure.twisub.tweets.service;

import com.jstructure.twisub.tweets.dto.TweetDto;

import java.util.List;

public interface TwitterService {

    List<TweetDto> search(String query);

    List<TweetDto> search(String query, Long sinceId);

}
