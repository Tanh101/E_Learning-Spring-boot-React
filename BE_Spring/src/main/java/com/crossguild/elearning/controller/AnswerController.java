package com.crossguild.elearning.controller;

import com.crossguild.elearning.dto.quiz.AnswerDTO;
import com.crossguild.elearning.dto.quiz.QuestionDTO;
import com.crossguild.elearning.model.quiz.Answer;
import com.crossguild.elearning.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/answer")
@RestController
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.getAll();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Answer>> getAnswerById(@PathVariable("id") Long id) {
        Optional<Answer> answer = answerService.getById(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<List<Answer>> getAllAnswerByQuestionId(@PathVariable("id") Long id) {
        List<Answer> answers = answerService.getAllAnswersByQuestionId(id);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AnswerDTO> addNewAnswer(@RequestBody AnswerDTO answerDTO) {
        Integer result = answerService.addNewAnswer(answerDTO.getId(),
                answerDTO.getIsCorrect(), answerDTO.getText(), answerDTO.getQuestionId());
        if (Integer.parseInt(result.toString()) >= 1) {
            return new ResponseEntity<>(new AnswerDTO(answerDTO.getId(),
                    answerDTO.getIsCorrect(), answerDTO.getText(), answerDTO.getQuestionId()), HttpStatus.OK);
        }
        return null;
    }

    @PostMapping("/add-list")
    public ResponseEntity<List<AnswerDTO>> addNewListAnswer(@RequestBody List<AnswerDTO> answerDTOList) {
        boolean check = true;
        for (AnswerDTO answerDTO : answerDTOList) {
            Integer result = answerService.addNewAnswer(answerDTO.getId(),
                    answerDTO.getIsCorrect(), answerDTO.getText(), answerDTO.getQuestionId());
            if (Integer.parseInt(result.toString()) < 1) {
                check = false;
                break;
            }
        }
        if (check) {
            return new ResponseEntity<>(answerDTOList, HttpStatus.CREATED);
        } else {
            return null;
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Answer> updateQuestion(@RequestBody Answer answer) {
        Answer updateAnswer = answerService.update(answer);
        return new ResponseEntity<>(updateAnswer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnswerById(@PathVariable("id") Long id) {
        answerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
