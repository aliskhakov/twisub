package com.jstructure.twisub.webapp.auth.repository;

import com.jstructure.twisub.webapp.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
