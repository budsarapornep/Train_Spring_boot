package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Fe2n_character")
public class Character {
    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "Fe2n_character_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY) //เวลาคิวรี่ข้อมูลจะได้เฉพาะข้อมูลของเทเบิ้ลนี้
    @JoinColumn(name = "player_id",referencedColumnName = "player_id",foreignKey = @ForeignKey(name = "characer_fk1"))
    private Player player;

    @Column(name = "level", nullable = false,precision = 3)
    private Integer level;

    @Column(name = "name", length = 50,nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

