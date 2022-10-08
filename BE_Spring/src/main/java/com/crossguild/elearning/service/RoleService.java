package com.crossguild.elearning.service;

import com.crossguild.elearning.model.user.ERole;
import com.crossguild.elearning.model.user.Role;

import java.util.Optional;

public interface RoleService extends Service<Role, Long> {
    Optional<Role> findByRoleName(ERole roleName);
}
