package com.example.demo.repository.impl;

import com.example.demo.dao.PlayerDao;
import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    private PlayerDao playerDao;

    @Autowired //สั่งให้ PlayerRepositoryImpl ทำงานอัตโนมัติ
    public PlayerRepositoryImpl(PlayerDao playerDao){
        this.playerDao = playerDao;
    }

    @Override
    public Player save(Player player) {
        return playerDao.save(player);
    }

    @Override
    public Player findByName(String name) {
        return playerDao.findByName(name);
    }

    @Override
    public void deleteById(Integer id) {

        playerDao.deleteById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerDao.findAll();
    } //list
}
