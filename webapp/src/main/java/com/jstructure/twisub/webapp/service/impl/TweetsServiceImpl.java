package com.jstructure.twisub.webapp.service.impl;

import com.jstructure.twisub.webapp.config.AppConfigProperties;
import com.jstructure.twisub.webapp.dto.QueryDto;
import com.jstructure.twisub.webapp.dto.TweetDto;
import com.jstructure.twisub.webapp.service.TweetsService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class TweetsServiceImpl implements TweetsService {

    private final AppConfigProperties properties;

    private final RestOperations restTemplate;

    @Override
    public List<QueryDto> getQueries(String username) {
        String path = String.format("%s/v1/queries/%s", properties.getTweetsUrl(), username);
        return restTemplate.exchange(path, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<QueryDto>>() {}).getBody();
    }

    @Override
    public List<TweetDto> getTweets(String username, UUID queryId) {
        String path = String.format(
                "%s/v1/tweets/%s/%s",
                properties.getTweetsUrl(),
                username,
                queryId
        );
        return restTemplate.exchange(path, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<TweetDto>>() {}).getBody();
    }

    @Override
    public void createQuery(QueryDto query) {
        String path = String.format("%s/v1/queries/",
                properties.getTweetsUrl(), query.getId()
        );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<QueryDto> request = new HttpEntity<>(query, headers);
        restTemplate.exchange(path, HttpMethod.POST, request, String.class);
    }

}
