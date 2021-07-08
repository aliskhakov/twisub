package com.jstructure.twisub.notifier.service.impl;

import com.jstructure.twisub.notifier.dto.MessageDto;
import com.jstructure.twisub.notifier.kafkalistener.NewTweetsListener;
import com.jstructure.twisub.notifier.sender.Sender;
import com.jstructure.twisub.notifier.service.SenderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SendersServiceImpl implements SenderService {

    private final Logger LOGGER = LoggerFactory.getLogger(NewTweetsListener.class);

    private final List<Sender> senders;

    @Override
    public void send(MessageDto message) {
        senders.forEach(sender -> {
            try {
                sender.send(message);
                LOGGER.info("Message has been sent to {} by {}", message.getTo(), sender);
            } catch (Exception e) {
                LOGGER.error("Error while sending message to {} by {}: {}", message.getTo(), sender, e.getMessage());
            }
        });
    }

}
