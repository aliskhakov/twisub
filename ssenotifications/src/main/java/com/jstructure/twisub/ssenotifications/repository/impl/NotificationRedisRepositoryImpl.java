package com.jstructure.twisub.ssenotifications.repository.impl;

import com.jstructure.twisub.ssenotifications.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@RequiredArgsConstructor
@Repository
public class NotificationRedisRepositoryImpl implements NotificationRepository {

    private final Jedis redisTemplate;

    @Override
    public void set(String to, String notification) {
        redisTemplate.set(to, notification);
    }

    @Override
    public String get(String to) {
        return redisTemplate.get(to);
    }

    @Override
    public void delete(String to) {
        redisTemplate.del(to);
    }

}
