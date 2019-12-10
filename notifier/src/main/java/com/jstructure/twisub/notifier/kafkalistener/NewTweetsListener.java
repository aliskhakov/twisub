package com.jstructure.twisub.notifier.kafkalistener;

import com.jstructure.twisub.notifier.dto.MessageDto;
import com.jstructure.twisub.notifier.dto.TweetDto;
import com.jstructure.twisub.notifier.dto.UserDto;
import com.jstructure.twisub.notifier.service.SenderService;
import com.jstructure.twisub.notifier.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewTweetsListener {

    @Autowired
    @Qualifier("emailSenderServiceImplBean")
    private SenderService emailSender;

    @Autowired
    @Qualifier("notificationsSenderServiceImplBean")
    private SenderService notificationsSender;

    @Autowired
    private UsersService usersService;

    // TODO: Maybe using single consumer for each type of notifications would be better.
    @KafkaListener(topics = "new-tweets")
    public void consume(@Payload List<TweetDto> tweets,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String username) {
        String messageText = tweets.stream()
                .map(t -> String.format(
                        "%s %s: %s",
                        t.getCreatedAt(),
                        t.getAuthor(),
                        t.getMessage()
                ))
                .collect(Collectors.joining("\n\r"));
        try {
            UserDto user = usersService.getUserInfo(username);
            emailSender.send(createMessage(user.getEmail(), messageText));
            notificationsSender.send(createMessage(username, messageText));
        } catch (Exception e) {
            // TODO
        }
    }

    // TODO: move to single class
    private MessageDto createMessage(String to, String text) {
        MessageDto message = new MessageDto();
        message.setSubject("New Tweets");
        message.setText(text);
        message.setTo(to);
        return message;
    }

}
