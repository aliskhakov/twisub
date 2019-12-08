package com.jstructure.twisub.tweets.service;

import java.util.concurrent.Future;

public interface MqService<K, M> {

    Future send(String topic, K key, M message);

    Future send(String topic, M message);

}
