package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Data3DTO {
    private Integer id;
    private String name;
    private Date bith;

    public Data3DTO(Integer id, String name, Date bith) {
        this.id = id;
        this.name = name;
        this.bith = bith;
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

    public Date getBith() {
        return bith;
    }

    public void setBith(Date bith) {
        this.bith = bith;
    }
//    private String playerName;
//    private String characterName;
//    private Integer matchId;
//    private Date startDate;
//    private Date endDate;
//    private String status;
//    private BigDecimal highestScore;
//    public  Data3DTO(String playerName, String characterName, Integer matchId, Date startDate, Date endDate,
//                     String status, BigDecimal highestScore){
//        this.playerName = playerName;
//        this.characterName = characterName;
//        this.matchId = matchId;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.status = status;
//        this.highestScore = highestScore;
//    }
    //getters and setters

}
