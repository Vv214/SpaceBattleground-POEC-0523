package com.templateproject.api.service;

public class Token {

    private Integer playerID;
    private String token;

    public Token() {
    }

    public Token(Integer playerID, String token) {
        this.playerID = playerID;
        this.token = token;
    }

    public Integer getplayerID() {
        return playerID;
    }

    public void setplayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
