package com.jstructure.twisub.users.service;


import com.jstructure.twisub.users.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
