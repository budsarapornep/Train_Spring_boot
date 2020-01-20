package com.example.demo.service.impl;

import com.example.demo.dto.Data3DTO;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Player;
import com.example.demo.mapper.PlayerMapper;
import com.example.demo.repository.CharacterRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;
    //private CharacterRepository characterRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        //this.characterRepository = characterRepository;
    }


    @Override
    public void save(PlayerDTO playerDTO) {
        Player player = PlayerMapper.getplayer(playerDTO);
        player = playerRepository.save(player);
    }

    @Override
    public List<PlayerDTO> findAll() {
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        List<Player> playerList = playerRepository.findAll();
        for (Player player : playerList) {
            playerDTOList.add(PlayerMapper.getPlayerDTO(player));
        }
        return playerDTOList;
    }

    @Override
    public PlayerDTO findById(Integer id) {
        Player player = playerRepository.findById(id);
        return PlayerMapper.getPlayerDTO(player);
    }

    @Override
    public PlayerDTO findByName(String name) {
        Player player = playerRepository.findByName(name);
        return PlayerMapper.getPlayerDTO(player);
    }

    @Override
    public void update(PlayerDTO playerDTO) {
        Player player = PlayerMapper.getplayer(playerDTO);
        player = playerRepository.update(player);
    }

    @Override
    public void deleteById(Integer id) {
        playerRepository.deleteById(id);
    }

//    @Override
//    public List<Data3DTO> fetchData() {
//        List<Data3DTO> playerDTOList = new ArrayList<>();
//        playerDTOList = playerRepository.fetchData();
//        return playerDTOList;
//    }


}
