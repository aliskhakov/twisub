package com.jstructure.twisub.twitterclient.api.v1;

import com.jstructure.twisub.twitterclient.dto.TweetDto;
import com.jstructure.twisub.twitterclient.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/search")
public class SearchController {

    @Autowired
    private TwitterService twitterService;

    @GetMapping(path = "/{query}", produces = "application/json")
    public List<TweetDto> search(@PathVariable String query,
                                @RequestParam(value = "since_id", required = false) Long sinceId) {
        List<TweetDto> result;
        if (sinceId != null) {
            result = twitterService.search(query, sinceId);
        } else {
            result = twitterService.search(query);
        }
        return result;
    }

}
