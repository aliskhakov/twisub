package com.jstructure.twisub.tweetsgetter.service.impl;

import com.jstructure.twisub.tweetsgetter.config.AppConfigProperties;
import com.jstructure.twisub.tweetsgetter.dto.QueryDto;
import com.jstructure.twisub.tweetsgetter.dto.TweetDto;
import com.jstructure.twisub.tweetsgetter.service.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.List;
import java.util.UUID;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Autowired
    private AppConfigProperties properties;

    @Autowired
    private RestOperations restTemplate;

    @Override
    public List<QueryDto> getQueries() {
        String path = String.format("%s/v1/queries/", properties.getTweetsUrl());
        return restTemplate.exchange(path, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<QueryDto>>() {}).getBody();
    }

    @Override
    public void createTweets(UUID queryId, List<TweetDto> tweets) {
        String path = String.format("%s/v1/tweets/%s",
                properties.getTweetsUrl(), queryId
        );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<TweetDto>> request = new HttpEntity<>(tweets, headers);
        restTemplate.exchange(path, HttpMethod.POST, request, String.class);
    }

    @Override
    public void updateQuery(QueryDto query) {
        String path = String.format("%s/v1/queries/%s",
                properties.getTweetsUrl(), query.getId()
        );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<QueryDto> request = new HttpEntity<>(query, headers);
        restTemplate.exchange(path, HttpMethod.PUT, request, String.class);
    }

}
