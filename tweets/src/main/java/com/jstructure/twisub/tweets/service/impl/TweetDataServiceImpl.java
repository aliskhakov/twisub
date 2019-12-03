package com.jstructure.twisub.tweets.service.impl;

import com.jstructure.twisub.tweets.dto.TweetDto;
import com.jstructure.twisub.tweets.entity.QueryEntity;
import com.jstructure.twisub.tweets.entity.TweetEntity;
import com.jstructure.twisub.tweets.mapper.TweetMapper;
import com.jstructure.twisub.tweets.repository.TweetRepository;
import com.jstructure.twisub.tweets.service.TweetDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TweetDataServiceImpl implements TweetDataService {

    private final TweetRepository repository;

    private final TweetMapper tweetMapper;

    @Override
    public void createTweet(UUID queryId, TweetDto tweetDto) {
        TweetEntity tweet = new TweetEntity();
        tweet.setQuery(new QueryEntity(queryId));
        tweet.setTwitterId(tweetDto.getId());
        tweet.setCreatedAt(tweetDto.getCreatedAt());
        tweet.setAuthor(tweetDto.getAuthor());
        tweet.setAuthor(tweetDto.getAuthor());
        tweet.setMessage(tweetDto.getMessage());
        repository.save(tweet);
    }

    @Override
    public void createTweets(UUID queryId, Iterable<TweetDto> tweets) {
        // TODO: optimise
        for (TweetDto tweet : tweets) {
            createTweet(queryId, tweet);
        }
    }

    @Override
    public Iterable<TweetDto> getAll(String username, UUID queryId) {
        Set<TweetDto> tweets = new HashSet<>();
        for (TweetEntity tweet : repository.findByUsernameAndQueryId(username, queryId)) {
            tweets.add(tweetMapper.map(tweet));
        }
        return tweets;
    }

}
