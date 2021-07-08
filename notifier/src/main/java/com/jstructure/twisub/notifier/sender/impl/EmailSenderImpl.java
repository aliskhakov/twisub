package com.jstructure.twisub.notifier.sender.impl;

import com.jstructure.twisub.notifier.config.AppConfigProperties;
import com.jstructure.twisub.notifier.dto.MessageDto;
import com.jstructure.twisub.notifier.sender.Sender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@RequiredArgsConstructor
@Service("emailSenderServiceImplBean")
public class EmailSenderImpl implements Sender {

    private final AppConfigProperties properties;

    private final RestOperations restTemplate;

    @Override
    public void send(MessageDto message) {
        String path = String.format("%s/v1/email/send/", properties.getEmailSenderUrl());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MessageDto> request = new HttpEntity<>(message, headers);
        restTemplate.exchange(path, HttpMethod.POST, request, String.class);
    }

}
