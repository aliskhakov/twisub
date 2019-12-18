package com.jstructure.twisub.notifier.kafkalistener;

import com.jstructure.twisub.notifier.dto.TweetDto;
import com.jstructure.twisub.notifier.messagebuilder.TweetsMessageBuilder;
import com.jstructure.twisub.notifier.service.SenderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class NewTweetsListener {

    private final Logger LOGGER = LoggerFactory.getLogger(NewTweetsListener.class);

    private final SenderService senderService;

    private final TweetsMessageBuilder messageBuilder;

    @KafkaListener(topics = "new-tweets")
    public void consume(@Payload List<TweetDto> tweets,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String username) {
        LOGGER.info("Start sending message to {}", username);
        senderService.send(
                messageBuilder.builder()
                        .to(username)
                        .tweets(tweets)
                        .build()
        );
    }

}
