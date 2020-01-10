package com.example.demo.service;

import com.example.demo.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    void save(CharacterDTO characterDTO);
    List<CharacterDTO> findAll();

    CharacterDTO findByName(String name);

    void deleteById(Integer id);
}
