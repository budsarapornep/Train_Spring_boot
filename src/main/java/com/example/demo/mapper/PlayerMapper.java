package com.example.demo.mapper;

import com.example.demo.dto.CharacterDTO;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Character;
import com.example.demo.entity.Player;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlayerMapper {
    private static SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public static Player getplayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setId(playerDTO.getId());
        player.setName(playerDTO.getName());

        try {
            player.setBirth(sm.parse(playerDTO.getBirth()));
        } catch (Exception e) {
            e.getMessage();
        }
        player.setHighestScore(new BigDecimal(0));
        return player;
    }

    public static PlayerDTO getPlayerDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        try {
            playerDTO.setBirth(sm.format(player.getBirth()));
        } catch (Exception e) {
            e.getMessage();
        }

        List<CharacterDTO> characterDTOList = new ArrayList<>();
        for(Character character: player.getCharacterList()){
            characterDTOList.add(CharacterMapper.getCharacterDTO(character));
        }
        playerDTO.setCharacterDTOList(characterDTOList);
    return playerDTO;
    }
}

