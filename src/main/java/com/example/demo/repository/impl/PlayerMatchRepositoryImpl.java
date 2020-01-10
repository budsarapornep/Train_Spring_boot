package com.example.demo.repository.impl;
import com.example.demo.dao.PlayerMatchDao;
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


}
