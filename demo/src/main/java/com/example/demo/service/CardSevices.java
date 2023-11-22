package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.cardModels;
import com.example.demo.repository.ICardRepository;

@Service
public class CardSevices implements ICardService{

    @Autowired
    ICardRepository cardRepository;

    @Override
    public List<cardModels> VerAll() {
        return cardRepository.findAll();
    }

    @Override
    public cardModels save(cardModels card) {
        return cardRepository.save(card);
    }

    @Override
    public cardModels FindById(long id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        cardRepository.deleteById(null);
    }


    
}
