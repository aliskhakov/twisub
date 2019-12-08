package com.jstructure.twisub.notifier.kafkalistener;

import com.jstructure.twisub.notifier.dto.MessageDto;
import com.jstructure.twisub.notifier.dto.TweetDto;
import com.jstructure.twisub.notifier.service.NotifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewTweetsListener {

    private final NotifierService notifier;

    @KafkaListener(topics = "new-tweets")
    public void consume(TweetDto tweet) {
        MessageDto message = new MessageDto();
        message.setSubject("New Tweet");
        message.setText(tweet.getMessage());
        message.setTo("aliskhakov@gmail.com"); // TODO:
        notifier.notify(message);
    }

}
