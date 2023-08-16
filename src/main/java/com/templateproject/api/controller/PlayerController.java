package com.templateproject.api.controller;

// import java.util.HashMap;
// import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.entity.Player;
import com.templateproject.api.service.PlayerService;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/player")
public class PlayerController {
  
  private PlayerService playerService;

  public PlayerController(){}

  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }
  //CREATE
  @PostMapping
  public ResponseEntity<Payload> addNewPlayer(@RequestBody Player player) {
    var payload = new Payload();
    try {
    playerService.addNewPlayer(
      player.getNickname(),
      player.getEmail(),
      player.getPassword(),
      player.getLevel()  
    );

    payload.setMessage(player.getNickname() + "created");
    return new ResponseEntity<>(payload,HttpStatus.OK);  
    
  } catch (Exception e) {

          payload.setData(null);
          payload.setMessage(e.getMessage());
          return new ResponseEntity<>(payload,HttpStatus.INTERNAL_SERVER_ERROR);  
  
      // TODO: handle exception
    }
    
  }

  //RESEARCH ALL
  @GetMapping ("/players") 
  public ResponseEntity <Payload> getPlayers() {
    var payload = new Payload();
    try {
      payload.setData(playerService.getAllPlayers());
      payload.setMessage("Get all Users : ");
      return new ResponseEntity <> (payload, HttpStatus.OK);        
    } catch (Exception e) {

      payload.setData(null);
      payload.setMessage(e.getMessage());
      return new ResponseEntity <> (payload, HttpStatus.OK);
      
      // TODO: handle exception
    }  
  }

  //RESEARCH ONE
  @GetMapping("/{nickname}")
  public ResponseEntity<Payload> getPlayer(@PathVariable String nickname) {
    var payload = new Payload(); 
    try {

        var player = playerService.getPlayer(nickname);
        payload.setMessage("Get Player by Name : ");
        payload.setData(player);
        return new ResponseEntity<>(payload, HttpStatus.OK);
    
      } catch (Exception e) {
    
        payload.setMessage(e.getMessage());
        payload.setData(null);
        return new ResponseEntity<>(payload, HttpStatus.OK);
      // TODO: handle exception
    
    }
  }

  //UPDATE ONE
  @PutMapping("/{nickname}")
  public ResponseEntity<Payload> updatePlayer(@PathVariable String nickname, @RequestBody Player player) {
    var payload = new Payload();
    try {
     playerService.updateUser( 
                              nickname, 
                              player.getNickname(),
                              player.getPassword(),
                              player.getEmail(),
                              player.getLevel()
                              );
      payload.setMessage("Player is Update");  
      return new ResponseEntity<>(payload, HttpStatus.OK);
    } catch (Exception e) {

      payload.setMessage(e.getMessage());
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
      // TODO: handle exception
    }
    
  }



//DELETE ONE
  @DeleteMapping("/{name}")
  public ResponseEntity<Payload> deletePlayer(@PathVariable String nickname) {
    var payload = new Payload();
    try {
      playerService.deletePlayerByNickName(nickname);
      payload.setMessage("'"+ nickname +"' deleted");
      return new ResponseEntity<>(payload, HttpStatus.OK);
    } catch (Exception e) {
      payload.setMessage(e.getMessage());
      return new ResponseEntity<>(payload, HttpStatus.OK);
      // TODO: handle exception
    }
  }

}