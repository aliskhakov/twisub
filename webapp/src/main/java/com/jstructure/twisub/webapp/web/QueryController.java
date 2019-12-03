package com.jstructure.twisub.webapp.web;

import com.jstructure.twisub.webapp.dto.QueryDto;
import com.jstructure.twisub.webapp.service.TweetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@Controller
@RequestMapping("/queries/")
@RequiredArgsConstructor
public class QueryController {

    private final TweetsService tweetsService;

    @GetMapping(path = "/", produces = "text/html")
    public String list(Model model, Principal principal) {
        model.addAttribute("queries", tweetsService.getQueries(principal.getName()));
        return "queries/list";
    }

    @GetMapping(path = "create/", produces = "text/html")
    public String create(Model model) {
        model.addAttribute("query", new QueryDto());
        return "queries/create";
    }

    @PostMapping(path = "create/", produces = "text/html")
    public String create(@ModelAttribute QueryDto query, Principal principal) {
        query.setUsername(principal.getName());
        tweetsService.createQuery(query);
        return "redirect:/queries/";
    }

    @GetMapping(path = "{queryId}/tweets/", produces = "text/html")
    public String tweets(@PathVariable UUID queryId, Model model, Principal principal) {
        model.addAttribute("tweets", tweetsService.getTweets(principal.getName(), queryId));
        return "tweets/list";
    }

}
