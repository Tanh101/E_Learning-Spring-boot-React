package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean exitsByUsername(String username);
    Boolean exitsByEmail(String email);

    User save(User user);
}
