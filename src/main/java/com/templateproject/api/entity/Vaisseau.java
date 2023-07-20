package com.templateproject.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vaisseau {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    private int PV;
    private int damage;
    private int fuel;
    private int speed;
    private int capacity;

    public Vaisseau() {
    };

    public Vaisseau(String name, String type, int PV, int damage, int fuel, int speed, int capacity) {
        this.name = name;
        this.type = type;
        this.PV = PV;
        this.damage = damage;
        this.fuel = fuel;
        this.speed = speed;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getType() {
        return type;
    }

    public String setType(String type) {
        return this.type = type;
    }

    public int getPV() {
        return PV;
    }

    public int setPV(int PV) {
        return this.PV = PV;
    }

    public int getDamage() {
        return damage;
    }

    public int setDamage(int damage) {
        return this.damage = damage;
    }

    public int getFuel() {
        return fuel;
    }

    public int setFuel(int fuel) {
        return this.fuel = fuel;
    }

    public int getSpeed() {
        return speed;
    }

    public int setSpeed(int speed) {
        return this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public int setCapacity(int capacity) {
        return this.capacity = capacity;
    }

}
