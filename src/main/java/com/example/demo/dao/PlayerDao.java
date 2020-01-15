package com.example.demo.dao;

import com.example.demo.dto.Data3DTO;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDao extends JpaRepository<Player, Integer> {
    Player findByName(String Name);
    Player save(Player player);

    @Query("SELECT new com.example.demo.dto.Data3DTO(player.id,player.name,player.birth) FROM Player as player")
    List<Data3DTO> fetchData();
}
