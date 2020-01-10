package com.example.demo.dao;

import com.example.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//JpaRepository<Player, Integer> ; Player = ชื่อ Entity ที่จะผูก , Integer ชนิดของ Primary Key ใน Entity นั้นๆ
//JPA เป็นตัวบอกว่าเราจะต้องทำยังไงบ้างเพื่อที่จะเชื่อมต่อ java class ให้ไปเป็น table หรือ column ที่อยู่ใน database
@Repository
public interface PlayerDao extends JpaRepository<Player, Integer> {
    Player findByName(String Name);
    Player save(Player player);
}
