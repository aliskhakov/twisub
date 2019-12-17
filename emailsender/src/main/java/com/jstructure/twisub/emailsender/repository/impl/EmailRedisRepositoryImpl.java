package com.jstructure.twisub.emailsender.repository.impl;

import com.jstructure.twisub.emailsender.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@RequiredArgsConstructor
@Repository
public class EmailRedisRepositoryImpl implements EmailRepository {

    private final Jedis redisTemplate;

    @Override
    public void set(String user, String email) {
        redisTemplate.set(user, email);
    }

    @Override
    public String get(String user) {
        return redisTemplate.get(user);
    }

    @Override
    public void delete(String user) {
        redisTemplate.del(user);
    }

}
