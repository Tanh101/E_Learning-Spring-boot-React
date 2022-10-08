package com.crossguild.elearning.service.impl;

import com.crossguild.elearning.model.quiz.Answer;
import com.crossguild.elearning.repo.AnswerRepo;
import com.crossguild.elearning.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepo answerRepo;

    public AnswerServiceImpl(AnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }

    @Override
    public List<Answer> getAll() {
        return answerRepo.findAll();
    }

    @Override
    public Optional<Answer> getById(Long id) {
        return answerRepo.findById(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepo.save(answer);
    }

    @Override
    public Answer update(Answer answer) {
        return answerRepo.save(answer);
    }

    @Override
    public void deleteById(Long id) {
        answerRepo.deleteById(id);
    }

    @Override
    public List<Answer> getAllAnswersByQuestionId(Long id) {
        return answerRepo.getAnswerByQuestionId(id);
    }
}
