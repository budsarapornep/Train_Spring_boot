package com.example.demo.dto;

import java.util.List;

public class PlayerDTO {

    private Integer id;
    private String name;
    private  String birth;
    private List<CharacterDTO> characterDTOList;

    public List<CharacterDTO> getCharacterDTOList() {
        return characterDTOList;
    }

    public void setCharacterDTOList(List<CharacterDTO> characterDTOList) {
        this.characterDTOList = characterDTOList;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
