package com.templateproject.api.service;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Player;
import com.templateproject.api.repository.PlayerRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class AuthService {

    private final PlayerRepository playerRepository;

    public AuthService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public boolean register(String nickname, String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            String passwordHashed = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, password.toCharArray());
            Player player = new Player(nickname, passwordHashed);
            playerRepository.save(player);
            return true;
        }
        return false;
    }

    public String findByNickname(String nickname, String password) {
        Player player = playerRepository.findByNickname(nickname);
        if (player != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), player.getPassword());
            return player.getNickname();
        }
        return null;
    }
}
