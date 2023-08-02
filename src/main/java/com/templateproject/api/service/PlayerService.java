package com.templateproject.api.service;

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

  public List<Player> getAllPlayers() {
    return playerRepository.findAll();
  }

  //CREATE 
  public Player addNewPlayer(Player player) {
    return playerRepository.save(player);
  }
  //RESEARCH ALL
  
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
    public ResponseEntity<String> deletePlayerById(Integer id) {
      playerRepository.deleteById(id);
      return new ResponseEntity<>("Player successfully deleted!", HttpStatus.OK);
    }
}