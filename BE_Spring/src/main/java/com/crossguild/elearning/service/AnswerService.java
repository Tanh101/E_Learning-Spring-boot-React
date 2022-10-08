package com.crossguild.elearning.service;

import com.crossguild.elearning.model.quiz.Answer;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerService extends Service<Answer, Long> {
    List<Answer> getAllAnswersByQuestionId(Long id);
}
