package com.templateproject.api.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.controller.payload.UserLogin;
import com.templateproject.api.controller.payload.UserRegister;
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
    public ResponseEntity<String> register(@RequestBody UserRegister user) {
        boolean isRegistered = authService.register(
                user.getNickname(),
                user.getPassword(),
                user.getConfirmPassword(),
                user.getEmail());
        if (isRegistered)
            return new ResponseEntity<>(user.getNickname() + " is registered !", HttpStatus.OK);
        else
            return new ResponseEntity<>("Register failed", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody UserLogin user) {
        String playerName = authService.findByNickname(user.getNickname(), user.getPassword());
        if (playerName != null) {
            request.getSession().setAttribute("playerName", playerName);
            return new ResponseEntity<>(user.getNickname() + " is connected", HttpStatus.OK);
        } else
            return new ResponseEntity<>("Auth failed", HttpStatus.BAD_REQUEST);
    }
}
