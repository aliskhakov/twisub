package com.jstructure.twisub.tweetsgetter.service.impl;

import com.jstructure.twisub.tweetsgetter.config.AppConfigProperties;
import com.jstructure.twisub.tweetsgetter.dto.TweetDto;
import com.jstructure.twisub.tweetsgetter.service.TwitterClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.List;

@Service
public class TwitterClientServiceImpl implements TwitterClientService {

    @Autowired
    private RestOperations restTemplate;

    @Autowired
    private AppConfigProperties properties;

    @Override
    public List<TweetDto> search(String query, Long sinceId) {
        String path = String.format(
                "%s/v1/search/%s%s",
                properties.getTwitterClientUrl(),
                query,
                sinceId == null
                        ? ""
                        : String.format("?since_id=%s", sinceId)
        );
        return restTemplate.exchange(path, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<TweetDto>>() {}).getBody();
    }

}
