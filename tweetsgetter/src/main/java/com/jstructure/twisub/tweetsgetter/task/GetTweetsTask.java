package com.jstructure.twisub.tweetsgetter.task;

import com.jstructure.twisub.tweetsgetter.dto.QueryDto;
import com.jstructure.twisub.tweetsgetter.dto.TweetDto;
import com.jstructure.twisub.tweetsgetter.service.TweetsService;
import com.jstructure.twisub.tweetsgetter.service.TwitterClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTweetsTask {

    public static final long PERIODICITY = 30000L;

    @Autowired
    private TwitterClientService twitterClientService;

    @Autowired
    private TweetsService tweetsService;

    @Scheduled(fixedDelay = PERIODICITY)
    public void run() {
        Iterable<QueryDto> queries = tweetsService.getQueries();
        for (QueryDto query : queries) {
            List<TweetDto> tweets;
            tweets = twitterClientService.search(query.getText(), query.getLastTweetId());
            if (!tweets.isEmpty()) {
                tweetsService.createTweets(query.getId(), tweets);
                TweetDto lastTweet = tweets.get(tweets.size() - 1);
                query.setLastTweetId(lastTweet.getId());
                tweetsService.updateQuery(query);
            }
        }
    }

}
