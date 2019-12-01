package com.jstructure.twisub.tweetsgetter.service;

import com.jstructure.twisub.tweetsgetter.dto.TweetDto;

import java.util.List;

public interface TwitterClientService {

    List<TweetDto> search(String query, Long sinceId);

}
