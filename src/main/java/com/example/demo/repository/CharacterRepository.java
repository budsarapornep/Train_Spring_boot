package com.example.demo.repository;

import com.example.demo.entity.Character;


import java.util.List;

public interface CharacterRepository {
    Character save(Character character); //Insert Update
    List<Character> findAll(); //Select * from
    Character findByName(String name); // select where from
    void deleteById(Integer id);
}
