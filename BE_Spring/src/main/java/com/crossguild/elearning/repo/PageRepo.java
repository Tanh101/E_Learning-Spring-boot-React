package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.Card.Page;
import com.crossguild.elearning.model.quiz.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepo extends JpaRepository<Page, Long> {
    List<Page> getPagesByCardId(Long id);
}
