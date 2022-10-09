package com.crossguild.elearning.service;

import com.crossguild.elearning.model.quiz.Quiz;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface QuizService extends Service<Quiz, Long> {
    Integer addNewQuiz(LocalDateTime createDate, String text, Long userId);
}
