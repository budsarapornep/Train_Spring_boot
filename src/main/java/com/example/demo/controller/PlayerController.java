package com.example.demo.controller;

import com.example.demo.dto.Data3DTO;
import com.example.demo.dto.PlayerDTO;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/player")
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody PlayerDTO playerDTO) {
        playerService.save(playerDTO);
        return new ResponseEntity<>("Create Complete", HttpStatus.OK);
    }

    @PostMapping(value = "/update" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody PlayerDTO playerDTO){
        playerService.save(playerDTO);
        return new ResponseEntity<>("Update Player Complete", HttpStatus.OK);
    }

    @GetMapping(value = "/player/{id:.+}")
    public ResponseEntity<PlayerDTO> player(@PathVariable Integer id) {
        PlayerDTO playerDTO = playerService.findById(id);
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{name:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerDTO> get(@PathVariable String name) {
        PlayerDTO playerDTO = playerService.findByName(name);
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlayerDTO>> list() {
        List<PlayerDTO> playerDTOList = playerService.findAll();
        return new ResponseEntity<>(playerDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id:.+}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        playerService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>("Delete complete", HttpStatus.OK);
    }

//    @GetMapping(value = "/get/fetchData",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Data3DTO>> fetchData(){
//        List<Data3DTO> fetchDataList = playerService.fetchData();
//        return new ResponseEntity<>(fetchDataList, HttpStatus.OK);
//    }
}
