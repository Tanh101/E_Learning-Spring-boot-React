package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.Role;
import com.crossguild.elearning.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
