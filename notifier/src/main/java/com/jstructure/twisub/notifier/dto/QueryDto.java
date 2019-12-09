package com.jstructure.twisub.notifier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDto implements Serializable {

    private UUID id;

    private String username;

    private String text;

    private Long lastTweetId;

    private Set<TweetDto> tweets;

}
