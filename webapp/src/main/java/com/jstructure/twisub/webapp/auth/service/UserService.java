package com.jstructure.twisub.webapp.auth.service;

import com.jstructure.twisub.webapp.auth.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
