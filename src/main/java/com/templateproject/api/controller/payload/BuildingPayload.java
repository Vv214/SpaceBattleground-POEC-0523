package com.templateproject.api.controller.payload;

public class BuildingPayload {

    private String name;
    private String type;
    private int level;
    private int buildingSize;
    private String description;
    private int coeff_prod;
    private int ironPrice;
    private int diamondPrice;
    private int hydrogenPrice;
    private int priceEnergy;
    private int timeBuilding;

    public BuildingPayload() {

    }

    public BuildingPayload(String name, String type, int level, int buildingSize, String description, int coeff_prod,
            int ironPrice, int diamondPrice, int hydrogenPrice, int priceEnergy, int timeBuilding) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.buildingSize = buildingSize;
        this.description = description;
        this.coeff_prod = coeff_prod;
        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice = hydrogenPrice;
        this.priceEnergy = priceEnergy;
        this.timeBuilding = timeBuilding;
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

    public int getBuildingSize() {
        return buildingSize;
    }

    public void setBuildingSize(int buildingSize) {
        this.buildingSize = buildingSize;
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

    public int getPriceEnergy() {
        return priceEnergy;
    }

    public void setPriceEnergy(int priceEnergy) {
        this.priceEnergy = priceEnergy;
    }

    public int getTimeBuilding() {
        return timeBuilding;
    }

    public void setTimeBuilding(int timeBuilding) {
        this.timeBuilding = timeBuilding;
    }

}
