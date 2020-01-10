package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Fe2n_PlayerMatch")
public class PlayerMatch {
    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "Fe2n_PlayerMatch_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id",referencedColumnName = "player_id",foreignKey = @ForeignKey(name = "playerMatch_fk1"))
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id",referencedColumnName = "match_id",foreignKey = @ForeignKey(name = "playerMatch_fk2"))
    private Match match;


    @Column(name = "score", nullable = false, precision = 9,scale = 2)
    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
