package com.templateproject.api.controller.payload;

public class ShipPayload {

    private String message;

    private String name;
    private String type;

    private Integer quantity;
    private Integer capacity;
    private Integer pv;
    private Integer damage;
    private Integer speed;
    private Integer fuel;

    private Integer ironPrice;
    private Integer diamondPrice;
    private Integer hydrogenPrice;
    private Integer energyPrice;

    public ShipPayload() {

    }

    public ShipPayload(String message, String name, String type, Integer quantity, Integer capacity, Integer pv, Integer damage, 
    Integer speed, Integer fuel, Integer ironPrice, Integer diamondPrice, 
    Integer hydrogenPrice, Integer energyPrice) {
        this.message = message;

        this.name = name;
        this.type = type;

        this.quantity = quantity;
        this.capacity = capacity;
        this.pv = pv;
        this.damage = damage;
        this.speed = speed;
        this.fuel = fuel;

        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice = hydrogenPrice;
        this.energyPrice = energyPrice;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

        public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

        public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

        public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
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


}
