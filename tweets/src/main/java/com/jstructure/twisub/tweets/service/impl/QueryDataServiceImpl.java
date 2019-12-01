package com.jstructure.twisub.tweets.service.impl;

import com.jstructure.twisub.tweets.entity.QueryEntity;
import com.jstructure.twisub.tweets.mapper.QueryMapper;
import com.jstructure.twisub.tweets.repository.QueryRepository;
import com.jstructure.twisub.tweets.service.QueryDataService;
import com.jstructure.twisub.tweets.dto.QueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QueryDataServiceImpl implements QueryDataService {

    @Autowired
    private QueryRepository repository;

    @Autowired
    private QueryMapper queryMapper;

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
    public void deleteQuery(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public QueryDto getQueryById(UUID id) {
        Optional<QueryEntity> optionalQuery = repository.findById(id);
        if (optionalQuery.isPresent()) {
            return queryMapper.map(optionalQuery.get());
        }
        throw new NoSuchElementException(id.toString());
    }

    @Override
    public Iterable<QueryDto> getAll() {
        Set<QueryDto> queries = new HashSet<>();
        for (QueryEntity query: repository.findAll()) {
            queries.add(queryMapper.map(query));
        }
        return queries;
    }

}
