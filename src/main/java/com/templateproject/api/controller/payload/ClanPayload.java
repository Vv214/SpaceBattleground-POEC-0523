package com.templateproject.api.controller.payload;

public class ClanPayload {

    private String clanName;
    private String clanTag;
    private Integer clanLvl;
    private String adminNickname;
    private Integer currentNumberPlayers;
    private Integer numberMaxPlayers;

    public ClanPayload() {
    }

    public String getName() {
        return clanName;
    }

    public void setName(String clanName) {
        this.clanName = clanName;
    }

    public String getTag() {
        return clanTag;
    }

    public void setTag(String clanTag) {
        this.clanTag = clanTag;
    }

    public Integer getLvl() {
        return clanLvl;
    }

    public void setLvl(Integer clanLvl) {
        this.clanLvl = clanLvl;
    }

    public String getAdminNickname() {
        return adminNickname;
    }

    public void setAdminNickname(String adminNickname) {
        this.adminNickname = adminNickname;
    }

    public Integer getCurrentNumberPlayers() {
        return currentNumberPlayers;
    }

    public void setCurrentNumberPlayers(Integer currentNumberPlayers) {
        this.currentNumberPlayers = currentNumberPlayers;
    }

    public Integer getNumberMaxPlayers() {
        return numberMaxPlayers;
    }

    public void setNumberMaxPlayers(Integer numberMaxPlayers) {
        this.numberMaxPlayers = numberMaxPlayers;
    }

}
