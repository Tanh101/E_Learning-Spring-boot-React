package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // Tim kiem user co ton tai trong db k
    Optional<User> findByUsername(String username);
    // Username da co trong db chua
    Boolean existsByUsername(String username);
    // Email da co trong db chua
    Boolean existsByEmail(String email);
}
