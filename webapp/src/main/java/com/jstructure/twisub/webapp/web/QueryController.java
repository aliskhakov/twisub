package com.jstructure.twisub.webapp.web;

import com.jstructure.twisub.webapp.dto.QueryDto;
import com.jstructure.twisub.webapp.service.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/queries/")
public class QueryController {

    @Autowired
    private TweetsService tweetsService;

    @GetMapping(path = "/", produces = "text/html")
    public String list(Model model) {
        model.addAttribute("queries", tweetsService.getQueries());
        return "queries/list";
    }

    @GetMapping(path = "create/", produces = "text/html")
    public String create(Model model) {
        model.addAttribute("query", new QueryDto());
        return "queries/create";
    }

    @PostMapping(path = "create/", produces = "text/html")
    public String create(@ModelAttribute QueryDto query) {
        tweetsService.createQuery(query);
        return "redirect:/queries/";
    }

    @GetMapping(path = "{id}/tweets/", produces = "text/html")
    public String tweets(@PathVariable UUID id, Model model) {
        model.addAttribute("tweets", tweetsService.getTweets(id));
        return "tweets/list";
    }

}
