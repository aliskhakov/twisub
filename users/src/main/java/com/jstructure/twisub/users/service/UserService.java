package com.jstructure.twisub.users.service;


import com.jstructure.twisub.users.dto.UserDto;

public interface UserService {

    void save(UserDto userDto);

    UserDto findByUsername(String username);

}
