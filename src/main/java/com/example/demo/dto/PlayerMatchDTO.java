package com.example.demo.dto;

public class PlayerMatchDTO {
    private Integer id;
    private Integer player_id;
    private Integer match_id;
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public Integer getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }



}
