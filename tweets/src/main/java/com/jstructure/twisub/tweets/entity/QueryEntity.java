package com.jstructure.twisub.tweets.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "query")
public class QueryEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "text", nullable = false, length = 500)
    private String text;

    @Column(name = "witter_last_tweet_id")
    private Long lastTweetId;

    @OneToMany(mappedBy = "query")
    private Set<TweetEntity> tweets;

    public QueryEntity(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryEntity query = (QueryEntity) o;
        return id.equals(query.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
