package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "fern_character")
public class Character {
    @Id //กำหนดให้ SequenceGenerator fern_player_id_seq เป็น Primary Key
    @SequenceGenerator(name = "pk_sequene", sequenceName = "fern_player_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence") //กำหนดให้ id รันเลขไปอัตโนมัติ

    //สร้าง attribute ขื่อ name ชนิด Integer
    @Column(name = "character_id", nullable = false)
    private Integer id;

    @Column(name = "player_id",nullable = false, insertable = false,updatable = false)
    private Integer playerId;

    @Column(name = "lavel", length = 50,nullable = false)
    private Integer level;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id",referencedColumnName = "player_id",foreignKey = @ForeignKey(name = "characer_fk1"))
    private Player player;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
