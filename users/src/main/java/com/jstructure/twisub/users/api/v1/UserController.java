package com.jstructure.twisub.users.api.v1;

import com.jstructure.twisub.users.dto.UserDto;
import com.jstructure.twisub.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/{username}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username) {
        UserDto user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody UserDto user) {
        userService.save(user);
    }

}
