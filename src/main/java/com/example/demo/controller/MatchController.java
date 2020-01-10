package com.example.demo.controller;

import com.example.demo.dto.MatchDTO;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {
    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody MatchDTO matchDTO) {
        matchService.save(matchDTO);
        return new ResponseEntity<>("Create Complete", HttpStatus.OK);
    }

    @GetMapping(value = "/get/{name:.+}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchDTO> get(@PathVariable String name){
        MatchDTO matchDTO = matchService.findByName(name);
        return new ResponseEntity<>(matchDTO,HttpStatus.OK);
    }
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MatchDTO>> list() {
        List<MatchDTO> matchDTOList = matchService.findAll();
        return new ResponseEntity<>(matchDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id:.+}")
    public ResponseEntity<String> delete(@PathVariable String id){
        matchService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>("Delete complete",HttpStatus.OK);
    }

    @GetMapping(value = "/update")
    public ResponseEntity<String> update(@PathVariable String id){
        matchService.updateById(Integer.parseInt(id));
        return new ResponseEntity<>("Update complete",HttpStatus.OK);
    }
}

