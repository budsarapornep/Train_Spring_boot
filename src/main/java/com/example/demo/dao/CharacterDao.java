package com.example.demo.dao;

import com.example.demo.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterDao extends JpaRepository<Character, Integer> {
    Character findByName(String Name);
}
