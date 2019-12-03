package com.jstructure.twisub.twitterclient.api.v1.mock;

import com.jstructure.twisub.twitterclient.config.AppConfigProperties;
import com.jstructure.twisub.twitterclient.dto.TweetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mock/v1/search")
public class SearchControllerMock {

    @Autowired
    private AppConfigProperties properties;

    @GetMapping(path = "/{query}", produces = "application/json")
    public List<TweetDto> search(@PathVariable String query,
                                @RequestParam(value = "since_id", required = false) Long sinceId) {
        List<TweetDto> tweets = new ArrayList<>();
        for (int i = 0; i < properties.getTweetsPerSearch(); i++) {
            TweetDto tweet = new TweetDto();
            tweet.setAuthor("testuser");
            tweet.setCreatedAt(new Date());
            tweet.setId(999999L);
            tweet.setMessage(String.format("This is a test tweet for query '%s'." +
                    "If you want to see real tweets set up Twitter API credentials.", query));
            tweets.add(tweet);
        }
        return tweets;
    }

}
