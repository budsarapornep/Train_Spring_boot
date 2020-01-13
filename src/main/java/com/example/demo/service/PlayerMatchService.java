package com.example.demo.service;


import com.example.demo.dto.PlayerMatchDTO;

import java.util.List;

public interface PlayerMatchService {

    void save(PlayerMatchDTO playerMatchDTO);

    void update();
    List data();
    List data2();

    void deleteById(Integer id);

//    void updateHighScore(PlayerMatchDTO playerMatchDTO);
}
