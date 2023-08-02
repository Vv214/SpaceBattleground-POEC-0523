package com.templateproject.api.controller.payload;

import java.util.Date;

public class TechnologiePayload {
    
    private String message; 
    
    private String name;
    private String description; 
    
    private Integer ironPrice;
    private Integer diamondPrice;
    private Integer hydrogenPrice;
    private Integer energyPrice;
    
    private Integer level; 
    private float coef_modifier;
    
    private Date timeSearch;
    private Date timeToStart;
    
    private boolean isDone;
    
    public TechnologiePayload () {}
    
    public TechnologiePayload(String message, String name, String description, Integer ironPrice, Integer diamondPrice, Integer hydrogenPrice,
            Integer energyPrice, Integer level, float coef_modifier, Date timeSearch, Date timeToStart, boolean isDone) {
        
        this.message=message;
    
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
    }
   
}
