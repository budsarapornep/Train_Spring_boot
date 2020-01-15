package com.example.demo.service;


import com.example.demo.dto.PlayerMatchDTO;

import java.util.List;

public interface PlayerMatchService {

    void save(PlayerMatchDTO playerMatchDTO);

    void update();
    List data();
    List data2();
//    List fetchData3DTOInnerJoin();

//    List postv4(PlayerMatchDTO playerMatchDTO);
//    List postv5(PlayerMatchDTO playerMatchDTO);
    void deleteById(Integer id);

//    void updateHighScore(PlayerMatchDTO playerMatchDTO);
}
