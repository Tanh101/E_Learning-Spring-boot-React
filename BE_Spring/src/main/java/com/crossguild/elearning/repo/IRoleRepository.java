package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.Role;
import com.crossguild.elearning.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRoleRepository extends JpaRepository<User, Long> {
    Optional<Role> findByName(String name);
}
