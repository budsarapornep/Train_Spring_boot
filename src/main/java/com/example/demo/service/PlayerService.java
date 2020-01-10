package com.example.demo.service;

import com.example.demo.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {

    void save(PlayerDTO player);
    List<PlayerDTO> findAll();

    PlayerDTO findByName(String name);

    void deleteById(Integer id);
}
