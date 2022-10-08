package com.crossguild.elearning.controller;

import com.crossguild.elearning.dto.quiz.QuestionDTO;
import com.crossguild.elearning.model.quiz.Answer;
import com.crossguild.elearning.model.quiz.Question;
import com.crossguild.elearning.service.AnswerService;
import com.crossguild.elearning.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuestionService questionService;
    private final AnswerService answerService;


    public QuizController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping("/questions/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable("id") Long id) {
        Optional<Question> question = questionService.getById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping("/question/add")
    public ResponseEntity<Integer> addNewQuestion(@RequestBody QuestionDTO question)  {
        Integer result = questionService.addNewQuestion(question.getId(), question.getText(), question.getUserId());
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/question/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        Question updateQuestion = questionService.update(question);
        return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable("id") Long id) {
        questionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/answers/all")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.getAll();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/answer/{id}")
    public ResponseEntity<Optional<Answer>> getAnswerById(@PathVariable("id") Long id) {
        Optional<Answer> answer = answerService.getById(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @PostMapping("/answer/add")
    public ResponseEntity<Answer> addNewAnswer(@RequestBody Answer answer) {
        Answer newAnswer = answerService.save(answer);
        return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
    }

    @PutMapping("/answer/update")
    public ResponseEntity<Answer> updateQuestion(@RequestBody Answer answer) {
        Answer updateAnswer = answerService.update(answer);
        return new ResponseEntity<>(updateAnswer, HttpStatus.OK);
    }

    @DeleteMapping("/answer/{id}")
    public ResponseEntity<?> deleteAnswerById(@PathVariable("id") Long id) {
        answerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
