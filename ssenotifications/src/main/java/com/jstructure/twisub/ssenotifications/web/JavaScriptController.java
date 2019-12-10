package com.jstructure.twisub.ssenotifications.web;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/js")
public class JavaScriptController {

    @GetMapping(path = "/{to}/sse-notifications.js", produces = "application/javascript")
    public String getJavaScript(@PathVariable String to, HttpServletRequest request, Model model) {
        model.addAttribute("to", to);
        String url = String.format(
                "%s://%s:%s/v1/notifications/%s/sse/",
                request.getScheme(),
                request.getServerName(),
                request.getServerPort(),
                to
        );
        model.addAttribute("url", url);
        return "sse-notifications.js";
    }

}
