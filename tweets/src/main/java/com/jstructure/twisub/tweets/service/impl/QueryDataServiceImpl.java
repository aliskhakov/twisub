package com.jstructure.twisub.tweets.service.impl;

import com.jstructure.twisub.tweets.dto.QueryDto;
import com.jstructure.twisub.tweets.entity.QueryEntity;
import com.jstructure.twisub.tweets.mapper.QueryMapper;
import com.jstructure.twisub.tweets.repository.QueryRepository;
import com.jstructure.twisub.tweets.service.QueryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class QueryDataServiceImpl implements QueryDataService {

    private final QueryRepository repository;

    private final QueryMapper queryMapper;

    @Override
    public void createQuery(QueryDto queryDto) {
        QueryEntity query = queryMapper.map(queryDto);
        repository.save(query);
        queryDto.setId(query.getId());
    }

    @Override
    public void updateQuery(QueryDto queryDto) {
        repository.save(queryMapper.map(queryDto));
    }

    @Override
    public void deleteQuery(String username, UUID id) {
        repository.deleteByUsernameAndId(username, id);
    }

    @Override
    public QueryDto getQueryByUsernameAndId(String username, UUID id) {
        Optional<QueryEntity> optionalQuery = repository.findOneByUsernameAndId(username, id);
        if (optionalQuery.isPresent()) {
            return queryMapper.map(optionalQuery.get());
        }
        throw new NoSuchElementException(id.toString());
    }

    @Override
    public Iterable<QueryDto> getAll() {
        Set<QueryDto> queries = new HashSet<>();
        for (QueryEntity query : repository.findAll()) {
            queries.add(queryMapper.map(query));
        }
        return queries;
    }

    @Override
    public Iterable<QueryDto> getAll(String username) {
        Set<QueryDto> queries = new HashSet<>();
        for (QueryEntity query : repository.findAllByUsername(username)) {
            queries.add(queryMapper.map(query));
        }
        return queries;
    }
}
