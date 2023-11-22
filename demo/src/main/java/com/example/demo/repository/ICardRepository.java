package com.example.demo.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.cardModels;

@Repository
public interface ICardRepository extends JpaRepository<cardModels, Long>{
    /*public List<cardModel> findAll();
    public int save(cardModel card);
    public int update(cardModel card);
    public int deleteById(int id);*/
}