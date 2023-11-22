package com.example.demo.service;

import java.util.List;

import com.example.demo.model.cardModels;

public interface ICardService {
    public List<cardModels> VerAll();
    public cardModels save(cardModels card);
    public cardModels FindById(long id);
    public void deleteById(long id);
}
