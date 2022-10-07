package com.crossguild.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoleRepo {
    @Autowired
    EntityManager entityManager = null;

    public default List<String> getRolesName(String username) {
        String sql = "Select r.role.roleName from AccountRole r where r.account.username = :username";
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("username", username);
        return query.getResultList();
    }
}
