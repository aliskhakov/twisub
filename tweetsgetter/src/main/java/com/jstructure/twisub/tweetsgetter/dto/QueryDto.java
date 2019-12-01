package com.jstructure.twisub.tweetsgetter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDto {

    private UUID id;

    private String text;

    private Long lastTweetId;

    private Set<TweetDto> tweets;

}
