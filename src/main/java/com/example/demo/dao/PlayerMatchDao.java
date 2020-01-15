package com.example.demo.dao;

import com.example.demo.dto.Data3DTO;
import com.example.demo.dto.DataDTO;
import com.example.demo.entity.PlayerMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;


@Repository
public interface PlayerMatchDao extends JpaRepository<PlayerMatch,Integer> {
    
    @Modifying
    @Query(
            value = "UPDATE fe2n_player\n" +
                    "SET highest_score = ff.cc\n" +
                    "FROM\n" +
                    "(select player_id,max(score) cc from fe2n_player_match group by player_id) ff\n" +
                    "WHERE\n" +
                    "fe2n_player.player_id = ff.player_id", nativeQuery = true)
    void update();


//    @Modifying
//    @Query("select new com.example.demo.dto.Data3DTO(player.name, character.name ,player_match.match_id,\n" +
//            "match.start_date, match.end_date,match.status, player.highest_score) "+
//            "from fe2n_player player\n" +
//            "inner join fe2n_character character on character.player_id = player.player_id\n" +
//            "inner join fe2n_player_match player_match on player_match.player_id =  player.player_id\n" +
//            "inner join fe2n_match match on match.match_id = player_match.match_id\n" +
//            "where match.status = 'finished'\n" +
//            "order by match.match_id,player.name")
//    List<Data3DTO> fetchData3DTOInnerJoin();

//    @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
//    User findByEmailAddress(String emailAddress);

//    @Modifying
//    @Query(
//            value = "select player.name as player_name, character.name as character_name,player_match.match_id,\n" +
//                    "match.start_date, match.end_date,match.status, player.highest_score\n" +
//                    "from fe2n_player player\n" +
//                    "inner join fe2n_character character on character.player_id = player.player_id\n" +
//                    "inner join fe2n_player_match player_match on player_match.player_id =  player.player_id\n" +
//                    "inner join fe2n_match match on match.match_id = player_match.match_id\n" +
//                    "where match.status = 'finished'\n" +
//                    "order by match.match_id,player.name",nativeQuery = true)
//    List<DataDTO> data();
//
//    List<DataDTO> postDTOs = em
//            .createNativeQuery(
//                    "SELECT " +
//                            "       p.id AS id, " +
//                            "       p.title AS title " +
//                            "FROM Post p " +
//                            "WHERE p.created_on > :fromTimestamp", DataDTO.class)
//            .setParameter( "fromTimestamp", Timestamp.from(
//                    LocalDateTime.of( 2016, 1, 1, 0, 0, 0 )
//                            .toInstant( ZoneOffset.UTC ) ))
//            .getResultList();
//
//    assertFalse( postDTOs.isEmpty() );
//
//    Tuple postDTO = postDTOs.get( 0 );
//    assertEquals(
//    1L,
//            ((Number) postDTO.get( "id" )).longValue()
//);
//
//    assertEquals(
//    "High-Performance Java Persistence",
//    postDTO.get( "title" )
//);

}
