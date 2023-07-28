package com.templateproject.api.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Technologie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @Column(unique = true, nullable = false)
    private String name;
    private String description; 
   
    private int ironPrice;
    private int diamondPrice;
    private int hydrogenPrice;
    private int energyPrice;
    
    private int level; 
    private float coef_modifier;
    
    private Date timeSearch;
    private Date timeToStart;

    private boolean isDone;

    public Technologie() {}

    public Technologie(String name, String description, int ironPrice, int diamondPrice, int hydrogenPrice,
            int energyPrice, int level, float coef_modifier, Date timeSearch, Date timeToStart, boolean isDone) {
        this.name = name;
        this.description = description;

        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice = hydrogenPrice;
        this.energyPrice = energyPrice;

        this.level = level;
        this.coef_modifier = coef_modifier;
        this.timeSearch = timeSearch;
        
        this.timeToStart = timeToStart;
        
        this.isDone = isDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIronPrice() {
        return ironPrice;
    }

    public void setIronPrice(int ironPrice) {
        this.ironPrice = ironPrice;
    }

    public int getDiamondPrice() {
        return diamondPrice;
    }

    public void setDiamondPrice(int diamondPrice) {
        this.diamondPrice = diamondPrice;
    }

    public int getHydrogenPrice() {
        return hydrogenPrice;
    }

    public void setHydrogenPrice(int hydrogenPrice) {
        this.hydrogenPrice = hydrogenPrice;
    }

    public int getEnergyPrice() {
        return energyPrice;
    }

    public void setEnergyPrice(int energyPrice) {
        this.energyPrice = energyPrice;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getCoef_modifier() {
        return coef_modifier;
    }

    public void setCoef_modifier(float coef_modifier) {
        this.coef_modifier = coef_modifier;
    }

    public Date getTimeSearch() {
        return timeSearch;
    }

    public void setTimeSearch(Date timeSearch) {
        this.timeSearch = timeSearch;
    }

    public Date getTimeToStart() {
        return timeToStart;
    }

    public void setTimeToStart(Date timeToStart) {
        this.timeToStart = timeToStart;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    };

    
}
