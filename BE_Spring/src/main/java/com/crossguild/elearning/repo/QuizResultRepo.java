package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.quiz.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface QuizResultRepo extends JpaRepository<QuizResult, Long> {

}
