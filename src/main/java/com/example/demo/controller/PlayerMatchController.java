package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.PlayerMatchService;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playermatch")
public class PlayerMatchController {
    private PlayerMatchService playerMatchService;

    @Autowired
    public PlayerMatchController(PlayerMatchService playerMatchService) {
        this.playerMatchService = playerMatchService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody PlayerMatchDTO playerMatchDTO) {
        playerMatchService.save(playerMatchDTO);
        return new ResponseEntity<>("Create Complete", HttpStatus.OK);
    }

//    @GetMapping(value = "/get/{name:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<PlayerMatchDTO> get(@PathVariable String name) {
//        PlayerMatchDTO characterDTO = playerMatchService.findByName(name);
//        return new ResponseEntity<>(characterDTO, HttpStatus.OK);
//    }


    @GetMapping(value = "/delete/{id:.+}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        playerMatchService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>("Delete complete", HttpStatus.OK);
    }

    @GetMapping(value = "/hightscore/")
    public ResponseEntity<String> update() {
        playerMatchService.update();
        return new ResponseEntity<>("Update highest score complete", HttpStatus.OK);
    }

    //    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<CharacterDTO>> list() {
//        List<CharacterDTO> playerDTOList = characterService.findAll();
//        return new ResponseEntity<>(playerDTOList, HttpStatus.OK);
//    }

    @GetMapping(value = "/get/value4")
    public ResponseEntity<List<DataDTO>> list() {
        List<DataDTO> dataDTOList = playerMatchService.data();
        return new ResponseEntity<>(dataDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/get/value5")
    public ResponseEntity<List<Data2DTO>> listData2(){
        List<Data2DTO> data2DTOList = playerMatchService.data2();
        return new ResponseEntity<>(data2DTOList, HttpStatus.OK);
    }

//    @GetMapping(value = "/get/value4-2")
//    public ResponseEntity<List<Data3DTO>> list2() {
//        List<Data3DTO> data3DTOList = playerMatchService.fetchData3DTOInnerJoin();
//        return new ResponseEntity<>(data3DTOList, HttpStatus.OK);
//    }

//    @PostMapping(value = "/post/value4", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<DataDTO> create(@PathVariable DataDTO dataDTO) {
//        playerMatchService.postv4(dataDTO);
//        return new ResponseEntity<>("Post value4 Complete", HttpStatus.OK);
//    }

//    @GetMapping(value = "/get/{name:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CharacterDTO> get(@PathVariable String name) {
//        CharacterDTO characterDTO = characterService.findByName(name);
//        return new ResponseEntity<>(characterDTO, HttpStatus.OK);
//    }

//    @PostMapping(value = "/post/value5", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> create(@RequestBody Data2DTO data2DTO) {
//        playerMatchService.postv5(data2DTO);
//        return new ResponseEntity<>("Post value5 Complete", HttpStatus.OK);
//    }
//    @PostMapping(value = "/data2/")
//    public ResponseEntity<List<>>
}
