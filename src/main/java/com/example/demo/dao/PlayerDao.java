package com.example.demo.dao;

import com.example.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao extends JpaRepository<Player, Integer> {
    Player findByName(String Name);
    Player save(Player player);
}
