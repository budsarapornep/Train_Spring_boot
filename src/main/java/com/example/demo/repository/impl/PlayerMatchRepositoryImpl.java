package com.example.demo.repository.impl;
import com.example.demo.dao.PlayerMatchDao;
import com.example.demo.dto.Data2DTO;
import com.example.demo.dto.DataDTO;
import com.example.demo.entity.PlayerMatch;
import com.example.demo.repository.PlayerMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlayerMatchRepositoryImpl implements PlayerMatchRepository {
private PlayerMatchDao playerMatchDao;
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public PlayerMatchRepositoryImpl(PlayerMatchDao playerMatchDao){
        this.playerMatchDao = playerMatchDao;
    }

    @Override
    public PlayerMatch save(PlayerMatch playerMatch) {
        return playerMatchDao.save(playerMatch);
    }

    @Override
    public void update() {
    playerMatchDao.update();
    }

    @Override
    public List<PlayerMatch> findAll() {
        return null;
    }


    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public List<DataDTO> data() {

        List<Object[]> dataDTOs = em
                .createNativeQuery(
                        "select player.name as player_name, character.name as character_name,player_match.match_id," +
                                " match.start_date, match.end_date,match.status, player.highest_score" +
                                " from fe2n_player player" +
                                " inner join fe2n_character character on character.player_id = player.player_id" +
                                " inner join fe2n_player_match player_match on player_match.player_id =  player.player_id" +
                                " inner join fe2n_match match on match.match_id = player_match.match_id" +
                                " where match.status = 'finished'" )
                .getResultList();

        List<DataDTO> dataDTOList = dataDTOs
                .stream()
                .map(x->{
                    DataDTO dataDTO = new DataDTO();
                    dataDTO.setPlayerName((String) x[0]);
                    dataDTO.setCharacterName((String) x[1]);
                    dataDTO.setMatchId((Integer) x[2]);
                    dataDTO.setStartDate((Date) x[3]);
                    dataDTO.setEndDate((Date) x[4]);
                    dataDTO.setStatus((String) x[5]);
                    dataDTO.setHighestScore((BigDecimal) x[6]);
                    return dataDTO;
                })
                .collect(Collectors.toList());
        System.out.println(dataDTOList);

        return dataDTOList;
    }

    @Override
    public List<Data2DTO> data2() {

        List<Object[]> data2DTOs = em
                .createNativeQuery(
                        "with temp as (select player.name as player_name,character.name as character_name,player_match.match_id,\n" +
                                " match.start_date, match.end_date,max(character.level),min(character.level),match.status\n" +
                                " from fe2n_player player\n" +
                                " inner join fe2n_character character on player.player_id = character.player_id\n" +
                                " inner join fe2n_player_match player_match on player_match.player_id =  player.player_id\n" +
                                " inner join fe2n_match match on match.match_id = player_match.match_id\n" +
                                " where match.status = 'finished'\n" +
                                " group by player.name,player_match.match_id,match.start_date,match.end_date,match.status,character.name\n" +
                                " order by player_match.match_id)\n" +
                                "\n" +
                                " select distinct * from\n" +
                                " (select player_name,character_name,match_id,start_date, end_date,min as level,status\n" +
                                " from temp order by match_id,player_name) t1\n" +
                                " union all\n" +
                                " select * from\n" +
                                " (select player_name,character_name,match_id,start_date, end_date,max as level,status\n" +
                                "  from temp order by match_id,player_name) t2" )
                .getResultList();

        List<Data2DTO> data2DTOList = data2DTOs
                .stream()
                .map(x->{
                    Data2DTO data2DTO = new Data2DTO();
                    data2DTO.setPlayerName((String) x[0]);
                    data2DTO.setCharacterName((String) x[1]);
                    data2DTO.setMathId((Integer) x[2]);
                    data2DTO.setStartDate((Date) x[3]);
                    data2DTO.setEndDate((Date) x[4]);
                    data2DTO.setLevel((Integer) x[5]);
                    data2DTO.setStatus((String) x[6]);

                    return data2DTO;
                })
                .collect(Collectors.toList());
        System.out.println(data2DTOList);

        return data2DTOList;
    }

}
