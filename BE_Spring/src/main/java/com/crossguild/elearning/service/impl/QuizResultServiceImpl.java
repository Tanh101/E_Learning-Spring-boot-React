package com.crossguild.elearning.service.impl;

import com.crossguild.elearning.model.quiz.QuizResult;
import com.crossguild.elearning.repo.QuizResultRepo;
import com.crossguild.elearning.service.QuizResultService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizResultServiceImpl implements QuizResultService {

    private final QuizResultRepo quizResultRepo;

    public QuizResultServiceImpl(QuizResultRepo quizResultRepo) {
        this.quizResultRepo = quizResultRepo;
    }

    @Override
    public List<QuizResult> getAll() {
        return quizResultRepo.findAll();
    }

    @Override
    public Optional<QuizResult> getById(Long id) {
        return quizResultRepo.findById(id);
    }

    @Override
    public QuizResult save(QuizResult quizResult) {
        return quizResultRepo.save(quizResult);
    }

    @Override
    public QuizResult update(QuizResult quizResult) {
        return quizResultRepo.save(quizResult);
    }

    @Override
    public void deleteById(Long id) {
        quizResultRepo.deleteById(id);
    }
}
