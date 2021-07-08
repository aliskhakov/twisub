package com.jstructure.twisub.users.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
@Table(name = "app_user", uniqueConstraints = @UniqueConstraint(columnNames={"username"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "username", nullable = false, length = 25)
    private String username;

    @NotNull
    @Size(min = 1)
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany
    private Set<Role> roles;

}
