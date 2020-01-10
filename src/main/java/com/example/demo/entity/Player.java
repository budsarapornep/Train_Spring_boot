package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity //@Entity ทำให้ public class Player {} เป็น Entity
@Table(name = "fern_player")

public class Player {

    @Id //กำหนดให้ SequenceGenerator fern_player_id_seq เป็น Primary Key
    @SequenceGenerator(name = "pk_sequene", sequenceName = "fern_player_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence") //กำหนดให้ id รันเลขไปอัตโนมัติ

    //สร้าง attribute ขื่อ name ชนิด Integer
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @Column(name = "birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birth;

    @Column(name = "highest_score", nullable = false, precision = 9,scale = 2)
    private BigDecimal highestScore;

    @Column(name = "created_datetime", nullable = false)
    private Date createdDateTime;

    @OneToMany(fetch = FetchType.LAZY)
    //FetchType.LAZY คือ ตอนที่ดึงข้อมูลของ Player มาไม่ต้องเอา Character ทั้งหมดมาด้วย  แต่ถ้าอยากให้ Character ทั้งหมดมาด้วยก็ต้องใช้ FetchType.EAGER
    //เวลาคิวรี่ข้อมูลจะได้เฉพาะข้อมูลของเทเบิ้ลนี้
    @JoinColumn(name = "player_id")
    private List<Character> characterList;

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public BigDecimal getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(BigDecimal highestScore) {
        this.highestScore = highestScore;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

}
