package com.jstructure.twisub.tweets.repository;

import com.jstructure.twisub.tweets.entity.QueryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QueryRepository extends CrudRepository<QueryEntity, UUID> {
}
