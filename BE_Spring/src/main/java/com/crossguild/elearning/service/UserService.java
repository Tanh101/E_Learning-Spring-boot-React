package com.crossguild.elearning.service;

import com.crossguild.elearning.model.user.User;

import java.util.Optional;

public interface UserService extends Service<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
