package com.example.demo.mapper;

import com.example.demo.dto.PlayerMatchDTO;
import com.example.demo.entity.Match;
import com.example.demo.entity.Player;
import com.example.demo.entity.PlayerMatch;

public class PlayerMatchMapper {
    public static PlayerMatch getplayermatch(PlayerMatchDTO playerMatchDTO) {
        PlayerMatch playerMatch = new PlayerMatch();

        playerMatch.setId(playerMatchDTO.getId());

        Player player = new Player();
        player.setId(playerMatchDTO.getPlayer_id());
        playerMatch.setPlayer(player);

        Match match = new Match();
        match.setId(playerMatchDTO.getMatch_id());
        playerMatch.setMatch(match);

        playerMatch.setScore(playerMatchDTO.getScore());

        return playerMatch;
    }

    public static PlayerMatchDTO getPlayerMatchDTO(PlayerMatch playerMatch) {
        PlayerMatchDTO playerMatchDTO = new PlayerMatchDTO();
        playerMatchDTO.setId(playerMatch.getId());
        playerMatchDTO.setPlayer_id(playerMatch.getPlayer().getId());
        playerMatchDTO.setMatch_id(playerMatch.getMatch().getId());
        playerMatchDTO.setScore(playerMatch.getScore());

        return playerMatchDTO;
    }
}
