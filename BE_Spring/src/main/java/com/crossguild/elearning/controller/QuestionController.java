package com.crossguild.elearning.controller;

import com.crossguild.elearning.dto.quiz.AnswerDTO;
import com.crossguild.elearning.dto.quiz.QuestionDTO;
import com.crossguild.elearning.model.quiz.Question;
import com.crossguild.elearning.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/question")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable("id") Long id) {
        Optional<Question> question = questionService.getById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<QuestionDTO> addNewQuestion(@RequestBody QuestionDTO questionDTO)  {
        Integer result = questionService.addNewQuestion(questionDTO.getId(), questionDTO.getText(), questionDTO.getUserId());
        if (Integer.parseInt(result.toString()) >= 1) {
            return new ResponseEntity<>(new QuestionDTO(questionDTO.getId(), questionDTO.getText(), questionDTO.getUserId()), HttpStatus.CREATED);
        }
        return null;
    }


    @PostMapping("/add-list")
    public ResponseEntity<List<QuestionDTO>> addNewListAnswer(@RequestBody List<QuestionDTO> questionDTOList) {
        boolean check = true;
        for (QuestionDTO questionDTO : questionDTOList) {
            Integer result = questionService.addNewQuestion(questionDTO.getId(), questionDTO.getText(), questionDTO.getUserId());
            if (Integer.parseInt(result.toString()) < 1) {
                check = false;
                break;
            }
        }
        if (check) {
            return new ResponseEntity<>(questionDTOList, HttpStatus.CREATED);
        } else {
            return null;
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        Question updateQuestion = questionService.update(question);
        return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable("id") Long id) {
        questionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
