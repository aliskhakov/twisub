package com.jstructure.twisub.tweets.service.impl;

import com.jstructure.twisub.tweets.dto.TweetDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TweetKafkaMqServiceImpl extends AbstractKafkaMqService<String, Iterable<TweetDto>> {

    public TweetKafkaMqServiceImpl(KafkaTemplate<String, Iterable<TweetDto>> kafkaTemplate) {
        super(kafkaTemplate);
    }

}
