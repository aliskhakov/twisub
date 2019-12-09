package com.jstructure.twisub.ssenotifications.repository.impl;

import com.jstructure.twisub.ssenotifications.dto.NotificationDto;
import com.jstructure.twisub.ssenotifications.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.Duration;

@RequiredArgsConstructor
@Repository
public class NotificationRedisRepositoryImpl implements NotificationRepository {

    private final RedisTemplate<String, NotificationDto> redisTemplate;

    private ValueOperations<String, NotificationDto> operations;

    @PostConstruct
    private void init() {
        operations = redisTemplate.opsForValue();
    }

    @Override
    public void set(String userId, NotificationDto notification) {
//        operations.set(userId, notification, Duration.ofSeconds(30L)); // TODO: remove hardcode
        operations.set(userId, notification);
    }

    @Override
    public NotificationDto get(String to) {
        return operations.get(to);
    }

    @Override
    public void delete(String to) {
        redisTemplate.delete(to);
    }

}
