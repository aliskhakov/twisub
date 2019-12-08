package com.jstructure.twisub.webapp.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class User {

    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    private String username;

    @NotNull
    @Size(min = 1)
    private String password;

    private Set<Role> roles;

}
