package com.jstructure.twisub.twitterclient.service.impl;

import com.jstructure.twisub.twitterclient.config.AppConfigProperties;
import com.jstructure.twisub.twitterclient.dto.TweetDto;
import com.jstructure.twisub.twitterclient.mapper.TweetMapper;
import com.jstructure.twisub.twitterclient.service.TwitterService;
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
    private AppConfigProperties properties;

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
    public List<TweetDto> search(String query, long sinceId) {
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
