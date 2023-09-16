package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Player;
import com.templateproject.api.repository.PlayerRepository;

@Service
public class PlayerService {

  private PlayerRepository playerRepository;

  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  // CREATE
  public void addNewPlayer(String nickname, String password, String email, Integer level) {
    var player = new Player(nickname, password, email.toLowerCase(), level);
    playerRepository.save(player);
  }

  // RESEARCH ALL
  public List<HashMap<String, Object>> getAllPlayers() {
    var payload = new ArrayList<HashMap<String, Object>>();

    List<Player> playerList = playerRepository.findAll();
    for (var player : playerList) {
      var newPlayer = new HashMap<String, Object>();
      newPlayer.put("Nickname :", player.getNickname());
      newPlayer.put("Email :", player.getEmail());
      newPlayer.put("Level :", player.getLevel());
      payload.add(newPlayer);
    }
    return payload;
  }

  // RESEARCH ONE
  public HashMap<String, Object> getPlayer(String nickname) {
    var newPlayer = new HashMap<String, Object>();
    var playerEntity = playerRepository.findByNickname(nickname);

    newPlayer.put("Nickname :", playerEntity.getNickname());
    newPlayer.put("Email :", playerEntity.getEmail());
    newPlayer.put("Level :", playerEntity.getLevel());

    return newPlayer;
  }

  // UPDATE ONE
  public void updateUser(String nicknameTarget, String nickname, String email, String password, Integer level)
      throws Exception {
    var player = playerRepository.findByNickname(nickname);

    if (player == null) {
      throw new Exception(nicknameTarget + "doesn't exist"); // TODO make our Exception (404 - Not found)
    }
    if (nickname != null) {
      player.setNickname(nickname);
    }
    if (email != null) {
      player.setEmail(email.toLowerCase());
    }
    if (password != null) {
      player.setPassword(password); // TODO Use BCrypt
    }
    if (level > 1) {
      player.setLevel(level);
    }
    playerRepository.save(player);
  }

  // DELETE ONE
  public ResponseEntity<String> deletePlayerByNickName(String nickname) {
    playerRepository.deletePlayerByNickname(nickname);
    return new ResponseEntity<>("Player successfully deleted!", HttpStatus.OK);
  }
}