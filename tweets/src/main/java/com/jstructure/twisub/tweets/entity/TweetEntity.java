package com.jstructure.twisub.tweets.entity;

import com.jstructure.twisub.tweets.eventlistener.TweetEntityListener;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(TweetEntityListener.class)
@Table(name = "tweet")
public class TweetEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "query_id")
    private QueryEntity query;

    @Column(name = "twitter_id", nullable = false)
    private Long twitterId;

    @Column(name = "twitter_created_at", nullable = false)
    private Date createdAt;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "message", nullable = false)
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TweetEntity tweet = (TweetEntity) o;
        return id.equals(tweet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
