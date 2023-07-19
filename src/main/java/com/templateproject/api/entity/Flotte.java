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
    private int power;
    private int totalPv;
    private int totalCapacity;
    private int speed;

    public Flotte() {
    };

    public Flotte(String name, int maxNumberShip, int positionX, int positionY, int power, int totalPv,
            int totalCapacity, int speed) {
        this.name = name;
        this.maxNumberShip = maxNumberShip;
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = power;
        this.totalPv = totalPv;
        this.totalCapacity = totalCapacity;
        this.speed = speed;
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

    public int getpower() {
        return power;
    }

    public void setpower(int power) {
        this.power = power;
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

    public int getspeed() {
        return speed;
    }

    public void setspeed(int speed) {
        this.speed = speed;
    }

}
