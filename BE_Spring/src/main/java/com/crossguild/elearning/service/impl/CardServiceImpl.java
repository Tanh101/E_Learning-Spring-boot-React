package com.crossguild.elearning.service.impl;

import com.crossguild.elearning.model.Card.Card;
import com.crossguild.elearning.repo.CardRepo;
import com.crossguild.elearning.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepo cardRepo;

    public CardServiceImpl(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }


    @Override
    public List<Card> getAll() {
        return cardRepo.findAll();
    }

    @Override
    public Optional<Card> getById(Long id) {
        return cardRepo.findById(id);
    }

    @Override
    public Card save(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public Card update(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public void deleteById(Long id) {
        cardRepo.deleteById(id);
    }
}
