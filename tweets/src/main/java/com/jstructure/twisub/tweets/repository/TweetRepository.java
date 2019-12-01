package com.jstructure.twisub.tweets.repository;

import com.jstructure.twisub.tweets.entity.TweetEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TweetRepository extends CrudRepository<TweetEntity, UUID> {

    @Query("SELECT t FROM TweetEntity t WHERE t.query.id = ?1")
    List<TweetEntity> findByQueryId(UUID queryId);

}
