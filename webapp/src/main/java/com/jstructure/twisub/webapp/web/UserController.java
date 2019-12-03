package com.jstructure.twisub.webapp.web;

import com.jstructure.twisub.webapp.auth.entity.User;
import com.jstructure.twisub.webapp.auth.service.SecurityService;
import com.jstructure.twisub.webapp.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final SecurityService securityService;

    @GetMapping("registration/")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "auth/registration";
    }

    @PostMapping("registration/")
    public String registration(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
        return "redirect://";
    }

    @GetMapping("login/")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "auth/login";
    }

}
