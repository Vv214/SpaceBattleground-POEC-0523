package com.templateproject.api.controller.payload;

import java.util.Date;

public class BuildingPayload {

    private String message; 
    
    private String name;
    private String type;
    private Integer level;
    
    private String description;
    private Integer coeff_prod;

    private Integer ironPrice;
    private Integer diamondPrice;
    private Integer hydrogenPrice;
    private Integer energyPrice;
        
    private Date timeBuilding;
    private Date timeToStart;

    public BuildingPayload() {

    }

    public BuildingPayload(String message, String name, String type, Integer level, String description,
            Integer coeff_prod, Integer ironPrice, Integer diamondPrice, Integer hydrogenPrice, Integer energyPrice,
            Date timeBuilding, Date timeToStart) {
        this.message = message;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCoeff_prod() {
        return coeff_prod;
    }

    public void setCoeff_prod(Integer coeff_prod) {
        this.coeff_prod = coeff_prod;
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
