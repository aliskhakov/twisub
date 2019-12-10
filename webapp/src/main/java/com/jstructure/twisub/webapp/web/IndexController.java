package com.jstructure.twisub.webapp.web;

import com.jstructure.twisub.webapp.config.AppConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final AppConfigProperties appConfigProperties;

    @GetMapping(path = "/", produces = "text/html")
    public String list(Model model, Principal principal) {
        String notificationsJsUrl = String.format(
                "%s/js/%s/sse-notifications.js",
                appConfigProperties.getNotificationsUrl(),
                principal.getName()
        );
        model.addAttribute("notificationsJsUrl", notificationsJsUrl);
        return "index";
    }

}
