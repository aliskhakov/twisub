package com.jstructure.twisub.users.service.impl;

import com.jstructure.twisub.users.service.MqService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.Future;

@RequiredArgsConstructor
public abstract class AbstractKafkaMqService<K, M> implements MqService<K, M> {

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
