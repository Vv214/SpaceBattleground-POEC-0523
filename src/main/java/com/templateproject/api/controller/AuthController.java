package com.templateproject.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.controller.payload.UserLogin;
import com.templateproject.api.controller.payload.UserRegister;
import com.templateproject.api.service.AuthService;

@RestController
public class AuthController {
    private final AuthService authService;

    AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRegister user) {
        boolean isRegistered = authService.register(
                user.getNickname(),
                user.getPassword(),
                user.getConfirmPassword());
        return isRegistered ? user.getNickname() + " is registred !" : "Register failed";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLogin user) {
        var isLogin = authService.findByNickname(user.getNickname(), user.getPassword());
        return isLogin ? user.getNickname() + " is connected" : user.getNickname() + " Login failed";
    }
}
