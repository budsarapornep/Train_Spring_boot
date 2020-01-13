package com.example.demo.service.impl;
import com.example.demo.dto.Data2DTO;
import com.example.demo.dto.DataDTO;
import com.example.demo.dto.PlayerMatchDTO;
import com.example.demo.entity.PlayerMatch;
import com.example.demo.mapper.PlayerMatchMapper;
import com.example.demo.repository.PlayerMatchRepository;
import com.example.demo.service.PlayerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
    public List data() {
        List<DataDTO> dataDTOList = playerMatchRepository.data();
        return dataDTOList;
    }

    @Override
    public List data2(){
        List<Data2DTO> data2DTOList = playerMatchRepository.data2();
            return data2DTOList;
    }

//    @Override
//    public List<PlayerDTO> findAll() {
//        List<PlayerDTO> playerDTOList = new ArrayList<>();
//        List<Player> playerList = playerRepository.findAll();
//        for (Player player : playerList) {
//            playerDTOList.add(PlayerMapper.getPlayerDTO(player));
//        }
//        return playerDTOList;
//    }

    @Override
    public void deleteById(Integer id) {
        playerMatchRepository.deleteById(id);
    }


}
