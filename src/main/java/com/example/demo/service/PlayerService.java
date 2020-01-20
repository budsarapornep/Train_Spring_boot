package com.example.demo.service;

import com.example.demo.dto.Data3DTO;
import com.example.demo.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {

    void save(PlayerDTO player);
    List<PlayerDTO> findAll();

    PlayerDTO findById(Integer id);
    PlayerDTO findByName(String name);
    void update(PlayerDTO playerDTO);
    void deleteById(Integer id);

//    List<Data3DTO> fetchData();
}
