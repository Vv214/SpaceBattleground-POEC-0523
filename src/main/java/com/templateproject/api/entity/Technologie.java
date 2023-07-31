package com.templateproject.api.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Technologie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column( unique = true, nullable = false, length = 50)
    private String name;
    private String description; 
   
    private Integer ironPrice;
    private Integer diamondPrice;
    private Integer hydrogenPrice;
    private Integer energyPrice;
    
    private Integer level; 
    private float coef_modifier;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeSearch;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeToStart;

    private boolean isDone;

    public Technologie() {}

    public Technologie(String name, String description, Integer ironPrice, Integer diamondPrice, Integer hydrogenPrice,
            Integer energyPrice, Integer level, float coef_modifier, Date timeSearch, Date timeToStart, boolean isDone) {
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

    public Integer getIronPrice() {
        return ironPrice;
    }

    public void setIronPrice(Integer ironPrice) {
        this.ironPrice = ironPrice;
    }

    public Integer getDiamondPrice() {
        return diamondPrice;
    }

    public void setDiamondPrice(Integer diamondPrice) {
        this.diamondPrice = diamondPrice;
    }

    public Integer getHydrogenPrice() {
        return hydrogenPrice;
    }

    public void setHydrogenPrice(Integer hydrogenPrice) {
        this.hydrogenPrice = hydrogenPrice;
    }

    public Integer getEnergyPrice() {
        return energyPrice;
    }

    public void setEnergyPrice(Integer energyPrice) {
        this.energyPrice = energyPrice;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
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
