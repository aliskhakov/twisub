package com.jstructure.twisub.tweets.task;

import com.jstructure.twisub.tweets.config.TwitterConfigProperties;
import com.jstructure.twisub.tweets.dto.QueryDto;
import com.jstructure.twisub.tweets.dto.TweetDto;
import com.jstructure.twisub.tweets.service.QueryDataService;
import com.jstructure.twisub.tweets.service.TweetDataService;
import com.jstructure.twisub.tweets.service.TwitterService;
import com.jstructure.twisub.tweets.service.impl.TwitterServiceImpl;
import com.jstructure.twisub.tweets.service.impl.TwitterServiceMockImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Component
public class GetTweetsTask {

    // TODO: remove hardcode
    private static final long PERIODICITY = 30000L;

    private TwitterService twitterClientService;

    private final ApplicationContext context;

    private final QueryDataService queryService;

    private final TweetDataService tweetsService;

    private final TwitterConfigProperties properties;

    @PostConstruct
    private void setTwitterClientService() {
        Class<? extends TwitterService> beanClass = properties.isUseMock()
                ? TwitterServiceMockImpl.class
                : TwitterServiceImpl.class;
        twitterClientService = context.getBean(beanClass);
    }

    @Scheduled(fixedDelay = PERIODICITY)
    public void run() {
        Iterable<QueryDto> queries = queryService.getAll();
        for (QueryDto query : queries) {
            List<TweetDto> tweets;
            tweets = twitterClientService.search(query.getText(), query.getLastTweetId());
            if (!tweets.isEmpty()) {
                tweetsService.createTweets(query.getUsername(), query.getId(), tweets);
                TweetDto lastTweet = tweets.get(tweets.size() - 1);
                query.setLastTweetId(lastTweet.getId());
                queryService.updateQuery(query);
            }
        }
    }

}
