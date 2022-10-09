package com.crossguild.elearning.controller;

import com.crossguild.elearning.model.quiz.Quiz;
import com.crossguild.elearning.model.quiz.QuizResult;
import com.crossguild.elearning.service.QuizResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/quiz-result/")
@RestController
public class QuizResultController {

    private final QuizResultService quizResultService;

    public QuizResultController(QuizResultService quizResultService) {
        this.quizResultService = quizResultService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuizResult>> getAllQuizzes() {
        List<QuizResult> quizzes = quizResultService.getAll();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<QuizResult>> getQuizById(@PathVariable("id") Long id) {
        Optional<QuizResult> quizResult = quizResultService.getById(id);
        return new ResponseEntity<>(quizResult, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<QuizResult> addNewQuiz(@RequestBody QuizResult quizResult)  {
        QuizResult newQuizResult = quizResultService.save(quizResult);
        return new ResponseEntity<>(newQuizResult, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<QuizResult> updateQuiz(@RequestBody QuizResult quiz) {
        QuizResult updateQuiz = quizResultService.save(quiz);
        return new ResponseEntity<>(updateQuiz, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuizById(@PathVariable("id") Long id) {
        quizResultService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
