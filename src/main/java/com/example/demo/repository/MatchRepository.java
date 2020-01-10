package com.example.demo.repository;

import com.example.demo.entity.Match;

import java.util.List;

public interface MatchRepository {
    Match save(Match match); //Insert Update
    List<Match> findAll(); //Select * from
    Match findByName(String name); // select where from
    void deleteById(Integer id);
    void updateById(Integer id);
}
