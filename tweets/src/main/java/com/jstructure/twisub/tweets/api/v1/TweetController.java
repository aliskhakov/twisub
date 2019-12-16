package com.jstructure.twisub.tweets.api.v1;

import com.jstructure.twisub.tweets.dto.TweetDto;
import com.jstructure.twisub.tweets.service.TweetDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/v1/tweets")
@RequiredArgsConstructor
public class TweetController {

    private final TweetDataService dataService;

    @Deprecated
    @PostMapping(path = "/{username}/{queryId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable String username, @PathVariable UUID queryId, @RequestBody List<TweetDto> tweets) {
        dataService.createTweets(username, queryId, tweets);
    }

    @GetMapping(path = "/{username}/{queryId}", produces = "application/json")
    public Iterable<TweetDto> list(@PathVariable String username, @PathVariable UUID queryId) {
        return dataService.getAll(username, queryId);
    }

}
