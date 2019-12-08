package com.jstructure.twisub.users.service.impl;

import com.jstructure.twisub.users.entity.User;
import com.jstructure.twisub.users.repository.RoleRepository;
import com.jstructure.twisub.users.repository.UserRepository;
import com.jstructure.twisub.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public void save(User user) {
        user.setRoles(new HashSet<>(roleRepository.findAll())); // TODO
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
