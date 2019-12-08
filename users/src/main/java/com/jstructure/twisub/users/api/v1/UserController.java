package com.jstructure.twisub.users.api.v1;

import com.jstructure.twisub.users.entity.User;
import com.jstructure.twisub.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/{username}/", produces = "application/json")
    public User getByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping(path = "/", produces = "application/json")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

}
