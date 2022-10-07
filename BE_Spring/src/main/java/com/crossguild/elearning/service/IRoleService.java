package com.crossguild.elearning.service;

import com.crossguild.elearning.model.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(String name);
}
