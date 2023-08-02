package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

  //CREATE 
  public void addNewPlayer(String nickname, String password, String email, Integer level) {
    var player = new Player (nickname, password, email.toLowerCase(), level);
    playerRepository.save(player);
  }
  //RESEARCH ALL
    public List<HashMap<String,Object>> getAllPlayers() {
    var payload = new ArrayList<HashMap<String, Object>>();

    List<Player> playerList = playerRepository.findAll();
    for (var player : playerList){
      var newPlayer = new HashMap<String, Object>();
      newPlayer.put("Nickname :", player.getNickname());
      newPlayer.put("Email :",player.getEmail());
      newPlayer.put("Level: ",player.getLevel());
      payload.add(newPlayer);
    }
    return payload;
  }
  //RESEARCH ONE
  public Player getPlayer(Integer id) {
    Optional<Player> optionalPlayer = playerRepository.findById(id);
    return optionalPlayer.get();
  }

  //UPDATE ONE
  public Player updateUser(Player player) {
    Player currentPlayer = playerRepository.findById(player.getId()).get();
    
    currentPlayer.setNickname(player.getNickname());
    currentPlayer.setEmail(player.getEmail());
    currentPlayer.setPassword(player.getPassword());
    currentPlayer.setLevel(player.getLevel());
    
    Player updatePlayer = playerRepository.save(currentPlayer);
    return updatePlayer;
  }

  //DELETE ONE 
    public ResponseEntity<String> deletePlayerByNickName(String nickname) {
      playerRepository.deletePlayerByNickname(nickname);
      return new ResponseEntity<>("Player successfully deleted!", HttpStatus.OK);
    }
}