package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Player;
import com.templateproject.api.repository.PlayerRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class AuthService {

    private List<Token> tokens;

    private final PlayerRepository playerRepository;
    private final MethodeService methodeService;

    public AuthService(PlayerRepository playerRepository, MethodeService methodeService) {
        this.playerRepository = playerRepository;
        this.methodeService = methodeService;
        tokens = new ArrayList<>();
    }

    public void register(String nickname, String password, String confirmPassword, String email) throws Exception {
        if (password.equals(confirmPassword) && !email.isEmpty() && !nickname.isEmpty()) {
            String passwordHashed = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, password.toCharArray());
            Player player = new Player(nickname, passwordHashed, email);
            playerRepository.save(player);
            methodeService.initializeRessourcesForNewPlayer(player.getId());
            System.out.println("Player saved back apres init ress");
            methodeService.definePlanetForPlayer(player.getId());
            System.out.println("Player saved back apres init planet");
        } else {
            throw new Exception("Invalid params ");
            // checks error message
        }
    }

    public String login(String nickname, String password) {
        Player dbPlayer = playerRepository.findByNickname(nickname);
        var result = BCrypt.verifyer().verify(password.toCharArray(), dbPlayer.getPassword());
        if (result.verified) {
            var token = GenerateToken.newUserToken(dbPlayer.getId());
            tokens.add(new Token(dbPlayer.getId(), token));
            return token;
        }
        return null;
    }

    public Integer findUserIdByToken(String token) {
        // tokens.stream().filter(t -> t.equals(token)).findFirst();
        for (Token item : tokens) {
            if (item.getToken().equals(token)) {
                return item.getplayerID();
            }
        }
        return null;
    }

    public Map<String, String> playerInfo(Integer userID) throws Exception {
        Player player = playerRepository.findById(userID).get();
        var playerInfo = new HashMap<String, String>();
        playerInfo.put("nickname", player.getNickname());
        playerInfo.put("email", player.getEmail());
        return playerInfo;
    }

    public void logout(String token) {
        for (Token item : tokens) {
            if (item.getToken().equals(token)) {
                tokens.remove(item);
                return;
            }
        }
    }

    public String findByNickname(String nickname, String password) {
        Player player = playerRepository.findByNickname(nickname);
        if (player != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), player.getPassword());
            if (result.verified) {
                return player.getNickname();
            }
            return null;
        }
        return null;
    }
}
