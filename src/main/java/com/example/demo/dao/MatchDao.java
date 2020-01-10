package com.example.demo.dao;

import com.example.demo.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchDao extends JpaRepository<Match, Integer> {
    Match findByStatus(String status);
}
