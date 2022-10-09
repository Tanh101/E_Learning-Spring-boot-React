package com.crossguild.elearning.service;

import com.crossguild.elearning.dto.quiz.QuestionDTO;
import com.crossguild.elearning.model.quiz.Question;
import com.crossguild.elearning.model.user.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionService extends Service<Question, Long> {
    Integer addNewQuestion(Long id, String text, Long userId);
    List<Question> getQuestionsByQuizId(Long id);

}
