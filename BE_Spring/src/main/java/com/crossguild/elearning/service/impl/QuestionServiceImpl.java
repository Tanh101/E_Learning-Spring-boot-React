package com.crossguild.elearning.service.impl;

import com.crossguild.elearning.dto.quiz.QuestionDTO;
import com.crossguild.elearning.model.quiz.Question;
import com.crossguild.elearning.model.user.User;
import com.crossguild.elearning.repo.QuestionRepo;
import com.crossguild.elearning.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;

    public QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public List<Question> getAll() {
        return questionRepo.findAll();
    }

    @Override
    public Optional<Question> getById(Long id) {
        return questionRepo.findById(id);
    }

    @Override
    public Question save(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public void deleteById(Long id) {
        questionRepo.deleteById(id);
    }

    @Override
    public Integer addNewQuestion(Long id, String text, Long userId) {
        return questionRepo.addNewQuestion(id, text, userId);
    }

    @Override
    public List<Question> getQuestionsByQuizId(Long id) {
        return questionRepo.getQuestionsByQuizId(id);
    }

}
