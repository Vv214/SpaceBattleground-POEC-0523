package com.templateproject.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flotte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int maxNumberShip;
    private int positionX;
    private int positionY;
    private int totalPower;
    private int totalPv;
    private int totalCapacity;
    private int vitesse;
    private int carburant;

    public Flotte() {
    };

    public Flotte(String name, int maxNumberShip, int positionX, int positionY, int totalPower, int totalPv,
            int totalCapacity, int vitesse, int carburant) {
        this.name = name;
        this.maxNumberShip = maxNumberShip;
        this.positionX = positionX;
        this.positionY = positionY;
        this.totalPower = totalPower;
        this.totalPv = totalPv;
        this.totalCapacity = totalCapacity;
        this.vitesse = vitesse;
        this.carburant = carburant;
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

    public int getMaxNumberShip() {
        return maxNumberShip;
    }

    public void setMaxNumberShip(int maxNumberShip) {
        this.maxNumberShip = maxNumberShip;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(int totalPower) {
        this.totalPower = totalPower;
    }

    public int getTotalPv() {
        return totalPv;
    }

    public void setTotalPv(int totalPv) {
        this.totalPv = totalPv;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getCarburant() {
        return carburant;
    }

    public void setCarburant(int carburant) {
        this.carburant = carburant;
    }

}
