package com.jstructure.twisub.twitterclient.service;

import com.jstructure.twisub.twitterclient.dto.TweetDto;

import java.util.List;

public interface TwitterService {

    List<TweetDto> search(String query);

    List<TweetDto> search(String query, long sinceId);

}
