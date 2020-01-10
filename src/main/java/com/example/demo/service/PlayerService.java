package com.example.demo.service;

import com.example.demo.dto.PlayerDTO;

import java.text.ParseException;
import java.util.List;

public interface PlayerService {
    void save(PlayerDTO player) throws ParseException;
    PlayerDTO findByName(String name);
    List<PlayerDTO> findAll();
    void deleteById(Integer id);
}
