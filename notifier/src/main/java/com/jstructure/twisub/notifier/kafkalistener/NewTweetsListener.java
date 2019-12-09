package com.jstructure.twisub.notifier.kafkalistener;

import com.jstructure.twisub.notifier.dto.MessageDto;
import com.jstructure.twisub.notifier.dto.TweetDto;
import com.jstructure.twisub.notifier.service.NotifierService;
import com.jstructure.twisub.notifier.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NewTweetsListener {

    private final NotifierService notifier;

    private final UsersService usersService;

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
            String email = usersService.getEmail(username);
            notify(email, messageText);
        } catch (Exception e) {
            // TODO
        }
    }

    // TODO: move to single mapper
    private void notify(String email, String text) {
        MessageDto message = new MessageDto();
        message.setSubject("New Tweets");
        message.setText(text);
        message.setTo(email);
        notifier.notify(message);
    }

}
