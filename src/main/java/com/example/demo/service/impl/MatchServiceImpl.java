package com.example.demo.service.impl;
import com.example.demo.dto.MatchDTO;
import com.example.demo.entity.Match;
import com.example.demo.mapper.MatchMapper;
import com.example.demo.repository.MatchRepository;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;
    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public void save(MatchDTO matchdto) {
        Match match = MatchMapper.getmatch(matchdto);
        match = matchRepository.save(match);
    }

    @Override
    public List<MatchDTO> findAll() {
        List<MatchDTO> playerDTOList = new ArrayList<>();
        List<Match> playerList = matchRepository.findAll();
        for (Match match : playerList) {
            playerDTOList.add(MatchMapper.getMatchDTO(match));
        }
        return playerDTOList;
    }

    @Override
    public MatchDTO findByName(String name) {
        Match match = matchRepository.findByName(name);
        return MatchMapper.getMatchDTO(match);
    }

    @Override
    public void deleteById(Integer id) {
       matchRepository.deleteById(id);
    }

    @Override
    public void updateById(Integer id) {
        matchRepository.updateById(id);
    }
}
