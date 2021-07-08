package com.jstructure.twisub.emailsender.kafkalistener;

import com.jstructure.twisub.emailsender.dto.UserDto;
import com.jstructure.twisub.emailsender.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NewUserListener {

    private final EmailRepository emailRepository;

    @KafkaListener(topics = "new-users")
    public void consume(@Payload UserDto user) {
        emailRepository.set(user.getUsername(), user.getEmail());
    }

}
