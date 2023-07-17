package com.templateproject.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String clanName;
    private String clanTag;
    private int clanLvl;
    private int numberMaxPlayers;
    private int currentNumberPlayers;
    private String adminNickname;

    public Clan(int id, String clanName, String clanTag, int clanLvl, int numberMaxPlayers,
            int currentNumberPlayers, String adminNickname) {
        this.id = id;
        this.clanName = clanName;
        this.clanTag = clanTag;
        this.clanLvl = clanLvl;
        this.numberMaxPlayers = numberMaxPlayers;
        this.currentNumberPlayers = currentNumberPlayers;
        this.adminNickname = adminNickname;
    }

    public String getClanName() {
        return clanName;
    }

    public String getClanTag() {
        return clanTag;
    }

    public int getClanLvl() {
        return clanLvl;
    }

    public int getNumberMaxPlayers() {
        return numberMaxPlayers;
    }

    public int getCurrentNumberPlayers() {
        return currentNumberPlayers;
    }

    public String getAdminNickname() {
        return adminNickname;
    }
}