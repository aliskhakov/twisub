package com.jstructure.twisub.users.service.impl;

import com.jstructure.twisub.users.dto.UserDto;
import com.jstructure.twisub.users.entity.User;
import com.jstructure.twisub.users.mapper.UserMapper;
import com.jstructure.twisub.users.repository.RoleRepository;
import com.jstructure.twisub.users.repository.UserRepository;
import com.jstructure.twisub.users.service.MqService;
import com.jstructure.twisub.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final MqService<String, UserDto> mqService;

    private final UserMapper userMapper;

    @Override
    public void save(UserDto userDto) {
        User user = userMapper.map(userDto);
        user.setRoles(new HashSet<>(roleRepository.findAll())); // TODO
        user = userRepository.save(user);
        userDto.setId(user.getId());
        userDto.setPassword(null);
        mqService.send("new-users", userDto); // TODO: It could be consistency problems if MQ broker didn't save message.
    }

    @Override
    public UserDto findByUsername(String username) {
        Optional<User> optional = userRepository.findByUsername(username);
        return optional.map(userMapper::map).orElse(null);
    }

}
