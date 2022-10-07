package com.crossguild.repo;

import com.crossguild.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AccountRepo extends JpaRepository<Account, Long> {
    Account getAccountByUsername(String username);
}
