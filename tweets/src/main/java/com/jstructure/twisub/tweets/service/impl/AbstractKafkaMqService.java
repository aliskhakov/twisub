package com.jstructure.twisub.tweets.service.impl;

import com.jstructure.twisub.tweets.service.MqService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.Future;

@RequiredArgsConstructor
abstract class AbstractKafkaMqService<K, M> implements MqService<K, M> {

    protected final KafkaTemplate<K, M> kafkaTemplate;

    @Override
    public Future send(String topic, K key, M message) {
        return kafkaTemplate.send(topic, key, message);
    }

    @Override
    public Future send(String topic, M message) {
        return send(topic, null, message);
    }

}
