package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.quiz.Answer;
import com.crossguild.elearning.model.quiz.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

}
