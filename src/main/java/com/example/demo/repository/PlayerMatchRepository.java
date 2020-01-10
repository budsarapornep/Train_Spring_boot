package com.example.demo.repository;

import com.example.demo.dto.DataDTO;
import com.example.demo.entity.PlayerMatch;

import java.util.List;

public interface PlayerMatchRepository {
    PlayerMatch save(PlayerMatch playerMatch); //Insert Update
    void update();
    List<PlayerMatch> findAll(); //Select * from
    void deleteById(Integer id);
    List<DataDTO> data();
}
