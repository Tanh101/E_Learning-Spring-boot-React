package com.crossguild.elearning.controller;

import com.crossguild.elearning.dto.quiz.QuestionDTO;
import com.crossguild.elearning.dto.quiz.QuizDTO;
import com.crossguild.elearning.model.quiz.Question;
import com.crossguild.elearning.model.quiz.Quiz;
import com.crossguild.elearning.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAll();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Quiz>> getQuizById(@PathVariable("id") Long id) {
        Optional<Quiz> quiz = quizService.getById(id);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<QuizDTO> addNewQuiz(@RequestBody QuizDTO quizDTO)  {
        Integer result = quizService.addNewQuiz(quizDTO.getCreateDate(), quizDTO.getTitle(), quizDTO.getUserId());
        if (Integer.parseInt(result.toString()) >= 1) {
            return new ResponseEntity<>(new QuizDTO(quizDTO.getCreateDate(), quizDTO.getTitle(), quizDTO.getUserId()), HttpStatus.CREATED);
        }
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        Quiz updateQuiz = quizService.save(quiz);
        return new ResponseEntity<>(updateQuiz, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuizById(@PathVariable("id") Long id) {
        quizService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
