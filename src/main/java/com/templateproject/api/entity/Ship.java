package com.templateproject.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 50)
    private String name;

    private String type;
    private Integer ironPrice;
    private Integer diamondPrice;
    private Integer hydrogenPrice;
    private Integer energyPrice;
    private Integer pv;
    private Integer damage;
    private Integer fuel;
    private Integer speed;
    private Integer capacity;
    private Integer size;
    private Integer quantity;

    public Ship() {
    };

    public Ship(String name, String type, Integer ironPrice,
            Integer diamondPrice, Integer hydrogenPrice,
            Integer energyPrice, Integer pv, Integer damage,
            Integer fuel, Integer speed, Integer range,
            Integer capacity, Integer size, Integer quantity) {

        this.name = name;
        this.type = type;
        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice = hydrogenPrice;
        this.energyPrice = energyPrice;
        this.pv = pv;
        this.damage = damage;
        this.fuel = fuel;
        this.speed = speed;
        this.capacity = capacity;
        this.size = size;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setenergyPrice(Integer energyPrice) {
        this.energyPrice = energyPrice;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPV(Integer pv) {
        this.pv = pv;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getsize() {
        return size;
    }

    public void setsize(Integer size) {
        this.size = size;
    }

}
