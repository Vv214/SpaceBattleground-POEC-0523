package com.templateproject.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.entity.Player;
import com.templateproject.api.service.PlayerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/players")
public class PlayerController {

  private PlayerService playerService;
œ
  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @GetMapping
  public List<Player> getPlayers() {
    return this.playerService.getAllPlayers();
  }

  @GetMapping("{id}")
  public Player getPlayer(@PathVariable("id") Integer id) {
    return this.playerService.getPlayer(id);
  }

  @PutMapping("{id}")
  public Player updatePlayer(@PathVariable("id") Integer id, @RequestBody Player player) {
    player.setId(id);
    return playerService.updateUser(player);
  }

  @PostMapping
  public Player addNewPlayer(@RequestBody Player player) {
    return this.playerService.addNewPlayer(player);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> deletePlayer(@PathVariable("id") Integer id) {
    return this.playerService.deletePlayerById(id);
  }
}