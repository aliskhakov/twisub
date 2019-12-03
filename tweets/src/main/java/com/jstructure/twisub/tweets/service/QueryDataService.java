package com.jstructure.twisub.tweets.service;

import com.jstructure.twisub.tweets.dto.QueryDto;

import java.util.UUID;

public interface QueryDataService {

    void createQuery(QueryDto queryDto);

    void updateQuery(QueryDto queryDto);

    void deleteQuery(String username, UUID id);

    QueryDto getQueryByUsernameAndId(String username, UUID id);

    @Deprecated
    Iterable<QueryDto> getAll();

    @Deprecated
    Iterable<QueryDto> getAll(String username);

}
