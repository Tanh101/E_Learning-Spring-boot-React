package com.crossguild.elearning.controller;

import com.crossguild.elearning.service.CardService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
}
