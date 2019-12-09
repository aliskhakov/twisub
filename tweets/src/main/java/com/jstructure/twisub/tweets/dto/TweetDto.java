package com.jstructure.twisub.tweets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetDto implements Serializable {

    private Long id;

    private Date createdAt;

    private String author;

    private String message;

    private QueryDto query;

}
