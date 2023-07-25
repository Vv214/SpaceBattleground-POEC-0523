package com.templateproject.api.controller.payload;

public class TechnologiePayload {
    
    private String message; 

    private String name;
    private int priceRessource1;
    private int priceRessource2;
    private int priceRessource3;
    private int priceEnergy;
    private String description; 
    private int lvl; 
    private float coef_modifier;
    private int timeSearch;
    private boolean isDone;

    public TechnologiePayload () {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceRessource1() {
        return priceRessource1;
    }

    public void setPriceRessource1(int priceRessource1) {
        this.priceRessource1 = priceRessource1;
    }

    public int getPriceRessource2() {
        return priceRessource2;
    }

    public void setPriceRessource2(int priceRessource2) {
        this.priceRessource2 = priceRessource2;
    }

    public int getPriceRessource3() {
        return priceRessource3;
    }

    public void setPriceRessource3(int priceRessource3) {
        this.priceRessource3 = priceRessource3;
    }

    public int getPriceEnergy() {
        return priceEnergy;
    }

    public void setPriceEnergy(int priceEnergy) {
        this.priceEnergy = priceEnergy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public float getCoef_modifier() {
        return coef_modifier;
    }

    public void setCoef_modifier(float coef_modifier) {
        this.coef_modifier = coef_modifier;
    }

    public int getTimeSearch() {
        return timeSearch;
    }

    public void setTimeSearch(int timeSearch) {
        this.timeSearch = timeSearch;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    
}
