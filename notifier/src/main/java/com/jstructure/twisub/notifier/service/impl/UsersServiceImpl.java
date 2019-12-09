package com.jstructure.twisub.notifier.service.impl;

import com.jstructure.twisub.notifier.config.AppConfigProperties;
import com.jstructure.twisub.notifier.dto.UserDto;
import com.jstructure.twisub.notifier.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final AppConfigProperties properties;

    private final RestOperations restTemplate;

    @Override
    public String getEmail(String username) {
        String path = String.format("%s/v1/users/%s/", properties.getUsersUrl(), username);
        UserDto user = restTemplate.exchange(path, HttpMethod.GET, null, UserDto.class).getBody();
        if (user != null) {
            return user.getEmail();
        }
        throw new RuntimeException(); // TODO
    }

}
