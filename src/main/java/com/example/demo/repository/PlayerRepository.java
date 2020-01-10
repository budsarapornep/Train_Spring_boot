package com.example.demo.repository;

import com.example.demo.entity.Player;

import java.util.List;

public interface PlayerRepository {
    Player save(Player player); //Insert Update
    Player findByName(String name); // select where from
    List<Player> findAll(); //Select * from //list
    void deleteById(Integer id);
}
