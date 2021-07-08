package com.jstructure.twisub.webapp.auth.service.impl;

import com.jstructure.twisub.webapp.auth.dto.User;
import com.jstructure.twisub.webapp.auth.service.UserService;
import com.jstructure.twisub.webapp.config.AppConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestOperations restTemplate;

    private final AppConfigProperties properties;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        String path = String.format("%s/v1/users/", properties.getUsersUrl());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        restTemplate.exchange(path, HttpMethod.POST, request, String.class);
    }

    @Override
    public User findByUsername(String username) {
        String path = String.format("%s/v1/users/%s/", properties.getUsersUrl(), username);
        try {
            return restTemplate.exchange(path, HttpMethod.GET, null, User.class).getBody();
        } catch (Throwable e) {
            return null;
        }
    }

}
