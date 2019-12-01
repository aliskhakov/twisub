package com.jstructure.twisub.tweets.service;

import com.jstructure.twisub.tweets.dto.QueryDto;

import java.util.UUID;

public interface QueryDataService {

    void createQuery(QueryDto queryDto);

    void updateQuery(QueryDto queryDto);

    void deleteQuery(UUID id);

    QueryDto getQueryById(UUID id);

    @Deprecated
    Iterable<QueryDto> getAll();

}
