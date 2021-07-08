package com.jstructure.twisub.users.dto;

import com.jstructure.twisub.users.entity.User;
import lombok.Data;

import java.util.Set;

@Data
public class RoleDto {

    private Long id;

    private String name;

    private Set<User> users;

}
