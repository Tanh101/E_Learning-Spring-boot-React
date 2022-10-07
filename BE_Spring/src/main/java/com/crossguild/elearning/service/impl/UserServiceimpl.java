package com.crossguild.elearning.service.impl;

import com.crossguild.elearning.model.User;
import com.crossguild.elearning.repo.IUserRepository;
import com.crossguild.elearning.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean exitsByUsername(String username) {
        return userRepository.exitsByUsername(username);
    }

    @Override
    public Boolean exitsByEmail(String email) {
        return userRepository.exitsByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
