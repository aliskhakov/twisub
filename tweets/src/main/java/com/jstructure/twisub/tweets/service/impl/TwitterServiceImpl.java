package com.jstructure.twisub.tweets.service.impl;

import com.jstructure.twisub.tweets.config.TwitterConfigProperties;
import com.jstructure.twisub.tweets.dto.TweetDto;
import com.jstructure.twisub.tweets.mapper.TweetMapper;
import com.jstructure.twisub.tweets.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterServiceImpl implements TwitterService {

    @Autowired
    private Twitter twitterTemplate;

    @Autowired
    private TweetMapper tweetMapper;

    @Autowired
    private TwitterConfigProperties properties;

    @Override
    public List<TweetDto> search(String query) {
        List<Tweet> tweets = twitterTemplate.searchOperations()
                .search(query, properties.getTweetsPerSearch()).getTweets();
        List<TweetDto> result = new ArrayList<>();
        for (Tweet tweet : tweets) {
            result.add(tweetMapper.map(tweet));
        }
        return result;
    }

    @Override
    public List<TweetDto> search(String query, Long sinceId) {
        SearchParameters p = new SearchParameters(query)
                .count(properties.getTweetsPerSearch())
                .sinceId(sinceId);
        List<Tweet> tweets = twitterTemplate.searchOperations().search(p).getTweets();
        List<TweetDto> result = new ArrayList<>();
        for (Tweet tweet : tweets) {
            result.add(tweetMapper.map(tweet));
        }
        return result;
    }

}
