package com.crossguild.elearning.controller;

import com.crossguild.elearning.model.Card.Card;
import com.crossguild.elearning.model.quiz.QuizResult;
import com.crossguild.elearning.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAll();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Card>> getCardById(@PathVariable("id") Long id) {
        Optional<Card> card = cardService.getById(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Card> addNewCard(@RequestBody Card card)  {
        Card newCard = cardService.save(card);
        return new ResponseEntity<>(newCard, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Card> updateCard(@RequestBody Card card) {
        Card updateCard = cardService.save(card);
        return new ResponseEntity<>(updateCard, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCardById(@PathVariable("id") Long id) {
        cardService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
