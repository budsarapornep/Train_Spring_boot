package com.example.demo.service.impl;

import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Player;
import com.example.demo.mapper.PlayerMapper;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public  PlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository= playerRepository;
    }

    @Override
    public void save(PlayerDTO playerDTO) throws ParseException {
        Player player = PlayerMapper.getPlayer(playerDTO); //ส่งค่า DTO ไป แมพ และเอาค่า รีเทิร์นมาเก็บใน player
        playerRepository.save(player); //เซฟฟฟฟ
    }

    @Override
    public PlayerDTO findByName(String name) {
        Player player = playerRepository.findByName(name);
        return PlayerMapper.getPlayerDTO(player);
    }

    @Override
    public void deleteById(Integer id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<PlayerDTO> findAll() {
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        List<Player> playerList = playerRepository.findAll(); //เรียกใช้งาน repo
        for (Player player : playerList) {
            playerDTOList.add(PlayerMapper.getPlayerDTO(player));
        }
        return playerDTOList;
    }
}
