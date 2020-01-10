package com.example.demo.controller;

import com.example.demo.dto.CharacterDTO;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.entity.Character;
import com.example.demo.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {
    private CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody CharacterDTO characterDTO) {
        characterService.save(characterDTO);
        return new ResponseEntity<>("Create Complete", HttpStatus.OK);
    }

    @GetMapping(value = "/get/{name:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterDTO> get(@PathVariable String name) {
        CharacterDTO characterDTO = characterService.findByName(name);
        return new ResponseEntity<>(characterDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CharacterDTO>> list() {
        List<CharacterDTO> playerDTOList = characterService.findAll();
        return new ResponseEntity<>(playerDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id:.+}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        characterService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>("Delete complete", HttpStatus.OK);
    }
}
