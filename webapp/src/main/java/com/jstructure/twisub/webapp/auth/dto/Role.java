package com.jstructure.twisub.webapp.auth.dto;

import lombok.Data;

import java.util.Set;

@Data
public class Role {

    private Long id;

    private String name;

    private Set<User> users;

}
