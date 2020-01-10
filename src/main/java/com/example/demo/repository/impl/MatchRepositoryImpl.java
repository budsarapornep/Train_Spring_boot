package com.example.demo.repository.impl;

import com.example.demo.dao.MatchDao;
import com.example.demo.entity.Match;
import com.example.demo.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatchRepositoryImpl implements MatchRepository {
    private MatchDao matchDao;

    @Autowired
    public MatchRepositoryImpl(MatchDao matchDao){
        this.matchDao = matchDao;
    }

    @Override
    public Match save(Match match) {
        return matchDao.save(match);
    }

    @Override
    public List<Match> findAll() {
        return matchDao.findAll();
    }

    @Override
    public Match findByName(String status) {
        return matchDao.findByStatus(status);
    }

    @Override
    public void deleteById(Integer id) {
    matchDao.deleteById(id);
    }

    @Override
    public void updateById(Integer id) {
    }
}
