package com.jstructure.twisub.notifier.messagebuilder;

import com.jstructure.twisub.notifier.dto.MessageDto;
import com.jstructure.twisub.notifier.dto.TweetDto;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetsMessageBuilder {

    @Builder
    public MessageDto newMessage(String to, List<TweetDto> tweets) {
        String text = tweets.stream()
                .map(t -> String.format(
                        "%s %s: %s",
                        t.getCreatedAt(),
                        t.getAuthor(),
                        t.getMessage()
                ))
                .collect(Collectors.joining("\n\r"));
        return new MessageDto(to, "New Tweets", text);
    }

}
