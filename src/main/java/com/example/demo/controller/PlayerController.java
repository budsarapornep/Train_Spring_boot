package com.example.demo.controller;

import com.example.demo.dto.PlayerDTO;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController  //@RestController ทำให้ public class TestController {} เป็น Controller
@RequestMapping("/api/player")  //เรียกจาก App ด้วย $http.get('http://localhost:8080/api/player');
public class PlayerController {
    private PlayerService playerService; //สร้าง Object ชื่อ playerService ชนิด PlayerService เพื่อใช้งาน Entity Player

    @Autowired //สั่งให้ PlayerController ทำงานอัตโนมัติ
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    //method บันทึกข้อมูล
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody PlayerDTO playerDTO) throws ParseException { //@RequestBody เป็นการนำ data ที่ส่งมา set ใน PlayerDTO
        playerService.save(playerDTO); //เรียกใช้ service
        return new ResponseEntity<>("Create Complete", HttpStatus.OK);
    }

    @GetMapping(value = "/get/{name:.+}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerDTO> get(@PathVariable String name){
        PlayerDTO playerDTO = playerService.findByName(name);
        return new ResponseEntity<>(playerDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlayerDTO>> list() {
        List<PlayerDTO> playerDTOList = playerService.findAll();
        return new ResponseEntity<>(playerDTOList, HttpStatus.OK);
    } //list

    @GetMapping(value = "/delete/{id:.+}") //delete/202
    public ResponseEntity<String> delete(@PathVariable String id){
        playerService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>("Delete complete",HttpStatus.OK);
    }

}
