package com.jstructure.twisub.webapp.auth.repository;

import com.jstructure.twisub.webapp.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
