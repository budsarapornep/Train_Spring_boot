package com.example.demo.mapper;

import com.example.demo.dto.CharacterDTO;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Character;
import com.example.demo.entity.Player;


public class CharacterMapper {

    public static Character getcharacter(CharacterDTO characterDTO) {
        Character character = new Character();
        character.setId(characterDTO.getId());
        character.setName(characterDTO.getName());
        character.setLevel(characterDTO.getLevel());

        try {
            Player player = new Player();
            player.setId(characterDTO.getPlayer_id());
            character.setPlayer(player);
        } catch (Exception e) {
            e.getMessage();
        }

        return character;
    }

    public static CharacterDTO getCharacterDTO(Character character) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(character.getId());
        characterDTO.setName(character.getName());
        characterDTO.setLevel(character.getLevel());
        characterDTO.setPlayer_id(character.getPlayer().getId());

        return characterDTO;
    }
}
