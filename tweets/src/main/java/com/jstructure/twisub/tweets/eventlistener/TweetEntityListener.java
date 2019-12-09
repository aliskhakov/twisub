package com.jstructure.twisub.tweets.eventlistener;

import com.jstructure.twisub.tweets.dto.TweetDto;
import com.jstructure.twisub.tweets.entity.TweetEntity;
import com.jstructure.twisub.tweets.mapper.TweetMapper;
import com.jstructure.twisub.tweets.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityListeners;
import javax.persistence.PostPersist;

@EntityListeners(TweetEntity.class)
public class TweetEntityListener {

    @Autowired
    private MqService<String, TweetDto> mqService;

    @Autowired
    private TweetMapper mapper;

    @PostPersist
    public void publishEvent(final TweetEntity tweet) {
        mqService.send("new-tweets", mapper.mapWithLinks(tweet));
    }

}
