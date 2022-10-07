package com.crossguild.elearning.service;

import com.crossguild.elearning.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name);
    Boolean exitsByUsername(String username);
    Boolean exitsByEmail(String email);
    User save(User user);
}
