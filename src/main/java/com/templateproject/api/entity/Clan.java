package com.templateproject.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String clanName;
    @Column(unique = true)
    private String clanTag;
    private Integer clanLvl;
    private Integer numberMaxPlayers;
    private Integer currentNumberPlayers;
    private String adminNickname;

    public Clan() {
    };

    public Clan(String clanName, String clanTag, Integer clanLvl, Integer numberMaxPlayers,
            Integer currentNumberPlayers, String adminNickname) {
        this.clanName = clanName;
        this.clanTag = clanTag;
        this.clanLvl = clanLvl;
        this.numberMaxPlayers = numberMaxPlayers;
        this.currentNumberPlayers = currentNumberPlayers;
        this.adminNickname = adminNickname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    public void setClanTag(String clanTag) {
        this.clanTag = clanTag;
    }

    public void setClanLvl(Integer clanLvl) {
        this.clanLvl = clanLvl;
    }

    public void setNumberMaxPlayers(Integer numberMaxPlayers) {
        this.numberMaxPlayers = numberMaxPlayers;
    }

    public void setCurrentNumberPlayers(Integer currentNumberPlayers) {
        this.currentNumberPlayers = currentNumberPlayers;
    }

    public void setAdminNickname(String adminNickname) {
        this.adminNickname = adminNickname;
    }

    public Integer getId() {
        return id;
    }

    public String getClanTag() {
        return clanTag;
    }

    public Integer getClanLvl() {
        return clanLvl;
    }

    public Integer getNumberMaxPlayers() {
        return numberMaxPlayers;
    }

    public Integer getCurrentNumberPlayers() {
        return currentNumberPlayers;
    }

    public String getAdminNickname() {
        return adminNickname;
    }
}