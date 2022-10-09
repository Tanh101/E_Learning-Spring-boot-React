package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.Card.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepo extends JpaRepository<Page, Long> {
}
