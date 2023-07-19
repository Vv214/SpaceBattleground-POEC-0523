package com.templateproject.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Technologie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int priceRessource1;
    private int priceRessource2;
    private int priceRessource3;
    private int priceEnergy;
    private int timeSearch;
    private boolean isDone;

    public Technologie() {

    };

    public Technologie(String name, int priceRessource1, int priceRessource2, int priceRessource3,
            int priceEnergy, int timeSearch, boolean isDone) {
        this.name = name;
        this.priceRessource1 = priceRessource1;
        this.priceRessource2 = priceRessource2;
        this.priceRessource3 = priceRessource3;
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