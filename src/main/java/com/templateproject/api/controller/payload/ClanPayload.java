package com.templateproject.api.controller.payload;

public class ClanPayload {

    private String clanName;
    private String clanTag;
    private int clanLvl;

    public ClanPayload() {}

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

    public int getLvl() {
        return clanLvl;
    }

    public void setLvl(int clanLvl) {
        this.clanLvl = clanLvl;
    }
}
