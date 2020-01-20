package com.example.demo.dao;

import com.example.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao extends JpaRepository<Player, Integer> {
    Player findByName(String Name);
    Player save(Player player);
    Player findById(int Id);

//    @Query("SELECT new com.example.demo.dto.Data3DTO(player.id,player.name,player.birth, character.name) " +
//            "FROM Player as player " +
//            "INNER JOIN Character as character " +
//            "on player.id = character.player")
//    List<Data3DTO> fetchData();
//    @Modifying
//    @Query(" UPDATE fe2n_player" +
//            " SET birth = '2019-10-16', created_datetime = '2020-01-08', highest_score = '10.0', name = 'NobitaChan'\n" +
//            " WHERE player_id = :playerId")
//    void update(@Param("player_id") int playerId, @Param("entryId") Date birth,);
}
