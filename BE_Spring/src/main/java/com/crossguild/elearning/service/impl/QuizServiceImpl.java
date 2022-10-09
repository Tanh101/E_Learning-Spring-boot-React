package com.crossguild.elearning.service.impl;

import com.crossguild.elearning.model.quiz.Quiz;
import com.crossguild.elearning.repo.QuizRepo;
import com.crossguild.elearning.service.QuizService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepo quizRepo;

    public QuizServiceImpl(QuizRepo quizRepo) {
        this.quizRepo = quizRepo;
    }

    @Override
    public List<Quiz> getAll() {
        return quizRepo.findAll();
    }

    @Override
    public Optional<Quiz> getById(Long id) {
        return quizRepo.findById(id);
    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Quiz update(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public void deleteById(Long id) {
        quizRepo.deleteById(id);
    }

    @Override
    public Integer addNewQuiz(LocalDateTime createDate, String text, Long userId) {
        return quizRepo.addNewQuiz(createDate, text, userId);
    }
}
