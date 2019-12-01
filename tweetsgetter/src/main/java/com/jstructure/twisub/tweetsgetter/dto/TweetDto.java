package com.jstructure.twisub.tweetsgetter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetDto implements Serializable {

    private long id;

    private Date createdAt;

    private String author;

    private String message;

}
