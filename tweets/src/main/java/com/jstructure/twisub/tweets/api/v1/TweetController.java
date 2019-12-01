package com.jstructure.twisub.tweets.api.v1;

import com.jstructure.twisub.tweets.dto.TweetDto;
import com.jstructure.twisub.tweets.service.TweetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/v1/tweets")
public class TweetController {

    @Autowired
    private TweetDataService dataService;

    @PostMapping(path = "/{queryId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable UUID queryId, @RequestBody List<TweetDto> tweets) {
        dataService.createTweets(queryId, tweets);
    }

    @GetMapping(path = "/{queryId}", produces = "application/json")
    public Iterable<TweetDto> list(@PathVariable UUID queryId) {
        return dataService.getAll(queryId);
    }

}
