package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Fe2n_player")
public class Player {
    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "fe2n_player_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")

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
