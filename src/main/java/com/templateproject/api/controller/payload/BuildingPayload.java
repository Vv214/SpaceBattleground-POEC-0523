package com.templateproject.api.controller.payload;

public class BuildingPayload {

    private String name;
    private String type;
    private int level;
    private int buildingSize;
    private String description;
    private int coeff_prod;
    private int priceRessource1;
    private int priceRessource2;
    private int priceRessource3;
    private int priceEnergy;
    private int timeBuilding;

    public BuildingPayload() {

    }

    public BuildingPayload(String name, String type, int level, int buildingSize, String description, int coeff_prod,
            int priceRessource1, int priceRessource2, int priceRessource3, int priceEnergy, int timeBuilding) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.buildingSize = buildingSize;
        this.description = description;
        this.coeff_prod = coeff_prod;
        this.priceRessource1 = priceRessource1;
        this.priceRessource2 = priceRessource2;
        this.priceRessource3 = priceRessource3;
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

    public int getTimeBuilding() {
        return timeBuilding;
    }

    public void setTimeBuilding(int timeBuilding) {
        this.timeBuilding = timeBuilding;
    }

}
