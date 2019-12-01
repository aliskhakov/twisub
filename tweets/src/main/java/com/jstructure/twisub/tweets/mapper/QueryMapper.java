package com.jstructure.twisub.tweets.mapper;

import com.jstructure.twisub.tweets.dto.QueryDto;
import com.jstructure.twisub.tweets.entity.QueryEntity;
import org.springframework.stereotype.Component;

@Component
public class QueryMapper {

    public QueryDto map(QueryEntity entity) {
        QueryDto dto = new QueryDto();
        dto.setId(entity.getId());
        dto.setText(entity.getText());
        dto.setLastTweetId(entity.getLastTweetId());
        return dto;
    }

    public QueryEntity map(QueryDto dto) {
        QueryEntity entity = new QueryEntity();
        entity.setId(dto.getId());
        entity.setText(dto.getText());
        entity.setLastTweetId(dto.getLastTweetId());
        return entity;
    }

}
