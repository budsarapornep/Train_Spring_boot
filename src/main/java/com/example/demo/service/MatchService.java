package com.example.demo.service;

import com.example.demo.dto.MatchDTO;

import java.util.List;

public interface MatchService {
    void save(MatchDTO matchdto);
    List<MatchDTO> findAll();
    MatchDTO findByName(String name);
    void deleteById(Integer id);
    void updateById(Integer id);

}
