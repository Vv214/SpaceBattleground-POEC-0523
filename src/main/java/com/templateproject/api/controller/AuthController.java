package com.templateproject.api.controller;

import org.springframework.http.HttpHeaders;
import java.util.HashMap;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.controller.payload.UserLogin;
import com.templateproject.api.controller.payload.UserRegister;
import com.templateproject.api.entity.Player;
import com.templateproject.api.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {
    private final AuthService authService;

    AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Payload> register(@RequestBody UserRegister user) {
        var payload = new Payload();
        try {
            authService.register(
                    user.getNickname(),
                    user.getPassword(),
                    user.getConfirmPassword(),
                    user.getEmail());
            payload.setMessage("Player '" + user.getNickname() + "' registered");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            payload.setMessage(e.getMessage() + " déja présent en BDD, merci de choisir un autre nickname.");
            return new ResponseEntity<>(payload, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            payload.setMessage(e.getMessage() + "erreur survenue durant la création du compte");
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<Payload> login(@RequestBody UserLogin user) {
        var payload = new Payload();
        try {
            String token = authService.login(user.getNickname(), user.getPassword());
            if (token != null) {
                payload.setMessage("Player " + user.getNickname() + " is connected");
                var data = new HashMap<String, String>();
                data.put("token", token);
                payload.setData(data);
                return new ResponseEntity<>(payload, HttpStatus.OK);
            } else {
                payload.setMessage("Invalid connection");
                return new ResponseEntity<>(payload, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info")
    public ResponseEntity<Payload> info(@RequestHeader HttpHeaders headers) {
        var payload = new Payload();
        var token = headers.get("x-token").get(0);
        try {
            var playerInfo = authService.playerInfo(token);
            payload.setMessage("Player informations");
            payload.setData(playerInfo);
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<Payload> logout(@RequestHeader HttpHeaders headers) {
        var payload = new Payload();
        var token = headers.get("x-token").get(0);
        authService.logout(token);
        payload.setMessage("User logout");
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }
}