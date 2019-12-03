package com.jstructure.twisub.tweets.repository;

import com.jstructure.twisub.tweets.entity.QueryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QueryRepository extends CrudRepository<QueryEntity, UUID> {

    @Query("SELECT q FROM QueryEntity q WHERE q.username = ?1 AND q.id = ?2")
    Optional<QueryEntity> findOneByUsernameAndId(String username, UUID queryId);

    @Query("DELETE FROM QueryEntity q WHERE q.username = ?1 AND q.id = ?2")
    void deleteByUsernameAndId(String username, UUID queryId);

    @Query("SELECT q FROM QueryEntity q WHERE q.username = ?1")
    List<QueryEntity> findAllByUsername(String username);

}


