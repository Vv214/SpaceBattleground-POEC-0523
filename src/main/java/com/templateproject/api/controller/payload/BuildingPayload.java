package com.templateproject.api.controller.payload;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class BuildingPayload {

    private String name;
    private String type;
    private int level;
    
    private String description;
    private int coeff_prod;

    private int ironPrice;
    private int diamondPrice;
    private int hydrogenPrice;
    private int energyPrice;
        
    private Date timeBuilding;
    private Date timeToStart;

    public BuildingPayload() {

    }
    
    public BuildingPayload(String name, String type, int level, String description, int coeff_prod, int ironPrice,
            int diamondPrice, int hydrogenPrice, int energyPrice, Date timeBuilding, Date timeToStart) {
        this.name = name;
        this.type = type;
        this.level = level;
        
        this.description = description;
        this.coeff_prod = coeff_prod;
        
        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice = hydrogenPrice;
        this.energyPrice = energyPrice;
        
        this.timeBuilding = timeBuilding;
        this.timeToStart = timeToStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCoeff_prod() {
        return coeff_prod;
    }

    public void setCoeff_prod(int coeff_prod) {
        this.coeff_prod = coeff_prod;
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

    public Date getTimeBuilding() {
        return timeBuilding;
    }

    public void setTimeBuilding(Date timeBuilding) {
        this.timeBuilding = timeBuilding;
    }

    public Date getTimeToStart() {
        return timeToStart;
    }

    public void setTimeToStart(Date timeToStart) {
        this.timeToStart = timeToStart;
    }

   

}
