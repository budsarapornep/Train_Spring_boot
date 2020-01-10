package com.example.demo.repository.impl;
import com.example.demo.dao.PlayerMatchDao;
import com.example.demo.entity.PlayerMatch;
import com.example.demo.repository.PlayerMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PlayerMatchRepositoryImpl implements PlayerMatchRepository {
private PlayerMatchDao playerMatchDao;

    @Autowired
    public PlayerMatchRepositoryImpl(PlayerMatchDao playerMatchDao){
        this.playerMatchDao = playerMatchDao;
    }

    @Override
    public PlayerMatch save(PlayerMatch playerMatch) {
        return playerMatchDao.save(playerMatch);
    }

    @Override
    public void update() {
    playerMatchDao.update();
    }

    @Override
    public List<PlayerMatch> findAll() {
        return null;
    }


    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public String data() {
        return playerMatchDao.data();
    }


}
