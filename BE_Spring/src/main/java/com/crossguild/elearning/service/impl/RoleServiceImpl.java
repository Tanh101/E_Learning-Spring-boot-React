package com.crossguild.elearning.service.impl;

import com.crossguild.elearning.model.user.ERole;
import com.crossguild.elearning.model.user.Role;
import com.crossguild.elearning.repo.RoleRepo;
import com.crossguild.elearning.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }

    @Override
    public Optional<Role> getById(Long id) {
        return roleRepo.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepo.deleteById(id);
    }

    @Override
    public Optional<Role> findByRoleName(ERole roleName) {
        return roleRepo.findByRole(roleName);
    }
}
