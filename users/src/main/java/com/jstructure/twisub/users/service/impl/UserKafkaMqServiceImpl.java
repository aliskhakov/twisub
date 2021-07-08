package com.jstructure.twisub.users.service.impl;

import com.jstructure.twisub.users.dto.UserDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserKafkaMqServiceImpl extends AbstractKafkaMqService<String, UserDto> {

    public UserKafkaMqServiceImpl(KafkaTemplate<String, UserDto> kafkaTemplate) {
        super(kafkaTemplate);
    }

}
