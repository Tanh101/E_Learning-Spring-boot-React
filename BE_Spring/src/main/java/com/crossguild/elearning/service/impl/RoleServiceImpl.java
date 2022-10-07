package com.crossguild.elearning.service.impl;

import com.crossguild.elearning.model.Role;
import com.crossguild.elearning.repo.IRoleRepository;
import com.crossguild.elearning.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
