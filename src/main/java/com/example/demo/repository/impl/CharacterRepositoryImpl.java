package com.example.demo.repository.impl;

import com.example.demo.dao.CharacterDao;
import com.example.demo.entity.Character;
import com.example.demo.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
    private CharacterDao characterDao;


    @Autowired
    public CharacterRepositoryImpl(CharacterDao character) {
        this.characterDao = character ;
    }

    @Override
    public Character save(Character character) {
        return characterDao.save(character);
    }

    @Override
    public List<Character> findAll() {

        return characterDao.findAll();
    }

    @Override
    public Character findByName(String name) {
        return characterDao.findByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        characterDao.deleteById(id);
    }
}

