package com.example.demo.service;


import com.example.demo.dto.PlayerMatchDTO;

public interface PlayerMatchService {

    void save(PlayerMatchDTO playerMatchDTO);

    void update();
    String data();

    void deleteById(Integer id);

//    void updateHighScore(PlayerMatchDTO playerMatchDTO);
}
