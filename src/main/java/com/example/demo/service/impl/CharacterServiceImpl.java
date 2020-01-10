package com.example.demo.service.impl;
import com.example.demo.dto.CharacterDTO;
import com.example.demo.entity.Character;
import com.example.demo.mapper.CharacterMapper;
import com.example.demo.repository.CharacterRepository;
import com.example.demo.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {
    private CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public void save(CharacterDTO characterDTO) {
        Character character = CharacterMapper.getcharacter(characterDTO);
        character = characterRepository.save(character);
    }

    @Override
    public List<CharacterDTO> findAll() {
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        List<Character> characterList = characterRepository.findAll();
        for (Character character : characterList) {
            characterDTOList.add(CharacterMapper.getCharacterDTO(character));
        }
        return characterDTOList;
    }

    @Override
    public CharacterDTO findByName(String name) {
        Character character = characterRepository.findByName(name);
        return CharacterMapper.getCharacterDTO(character);
    }

    @Override
    public void deleteById(Integer id) {
        characterRepository.deleteById(id);
    }
}
