package com.templateproject.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    private int priceRessource1;
    private int priceRessource2;
    private int priceRessource3;
    private int priceEnergy;
    private int pv;
    private int damage;
    private int fuel;
    private int speed;
    private int capacity;
    private int shipSize;
    private int quantity;

    public Ship() {
    };

    public Ship(String name, String type, int priceRessource1,
            int priceRessource2, int priceRessource3,
            int priceEnergy, int pv, int damage,
            int fuel, int speed,
            int capacity, int shipSize, int quantity) {
        this.name = name;
        this.type = type;
        this.priceRessource1 = priceRessource1;
        this.priceRessource2 = priceRessource2;
        this.priceRessource3 = priceRessource3;
        this.priceEnergy = priceEnergy;
        this.pv = pv;
        this.damage = damage;
        this.fuel = fuel;
        this.speed = speed;
        this.capacity = capacity;
        this.shipSize = shipSize;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getPv() {
        return pv;
    }

    public void setPV(int pv) {
        this.pv = pv;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }
}
