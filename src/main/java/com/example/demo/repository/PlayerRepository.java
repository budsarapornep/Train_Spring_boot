package com.example.demo.repository;

import com.example.demo.dto.Data3DTO;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Player;

import java.util.List;

public interface PlayerRepository {

        Player save(Player player); //Insert Update
        List<Player> findAll(); //Select * from
        Player findByName(String name); // select where from
        void deleteById(Integer id);
        List<Data3DTO> fetchData();
//        List<Data3DTO> fetchData();
}
