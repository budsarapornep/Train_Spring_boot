package com.example.demo.service.impl;
import com.example.demo.dto.PlayerMatchDTO;
import com.example.demo.entity.PlayerMatch;
import com.example.demo.mapper.PlayerMatchMapper;
import com.example.demo.repository.PlayerMatchRepository;
import com.example.demo.service.PlayerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class PlayerMatchServiceImpl implements PlayerMatchService {

    private PlayerMatchRepository playerMatchRepository;

    @Autowired
    public PlayerMatchServiceImpl(PlayerMatchRepository playerMatchRepository) {
        this.playerMatchRepository = playerMatchRepository;
    }

    @Override
    public void save(PlayerMatchDTO playerMatchDTO) {
        PlayerMatch playerMatch = PlayerMatchMapper.getplayermatch(playerMatchDTO);
        playerMatch = playerMatchRepository.save(playerMatch);
    }

    @Override
    public void update() {
        playerMatchRepository.update();
    }

    @Override
    public String data() {
        return playerMatchRepository.data();
    }


    @Override
    public void deleteById(Integer id) {
        playerMatchRepository.deleteById(id);
    }


}