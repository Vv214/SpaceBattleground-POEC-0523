package com.templateproject.api.controller.payload;

public class ClanPayload {

    private String clanName;
    private String clanTag;
    private Integer clanLvl;

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

    public Integer getLvl() {
        return clanLvl;
    }

    public void setLvl(Integer clanLvl) {
        this.clanLvl = clanLvl;
    }
}

