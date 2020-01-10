package com.example.demo.mapper;

import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Player;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PlayerMapper {

    private static SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public static Player getPlayer(PlayerDTO playerDTO) throws ParseException { //รับค่า DTO มา
        Player player = new Player(); //set ค่าให้ enity
        player.setId(playerDTO.getId());
        player.setName(playerDTO.getName());
        player.setHighestScore(playerDTO.getHighestScore());
//        try {
            player.setBirth(sm.parse(playerDTO.getBirth()));
            player.setCreatedDateTime(sm.parse(playerDTO.getCreatedDateTime()));
//        } catch (Exception e) {
//            e.getMessage();
//        }

                        return player; //รีเทิร์นค่ากลับไป
    }

    public static PlayerDTO getPlayerDTO(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setBirth(sm.format(player.getBirth()));
        playerDTO.setCreatedDateTime(sm.format(player.getCreatedDateTime()));
        playerDTO.setHighestScore(player.getHighestScore());

        return playerDTO;
    }
}
