package com.templateproject.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fleet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column( unique = true, nullable = false, length = 50)
    private String name;

    private Integer maxNumberShip;

    private Integer positionX;
    private Integer positionY;

    private Integer power;
    private Integer totalPv;
    private Integer totalCapacity;

    private Integer speed;
   
    public Fleet() {
    };

    public Fleet(String name, Integer maxNumberShip, Integer positionX, Integer positionY, Integer power, Integer totalPv,
            Integer totalCapacity, Integer speed ) {
        this.name = name;
        this.maxNumberShip = maxNumberShip;
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = power;
        this.totalPv = totalPv;
        this.totalCapacity = totalCapacity;
        this.speed = speed;        
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

    public Integer getMaxNumberShip() {
        return maxNumberShip;
    }

    public void setMaxNumberShip(Integer maxNumberShip) {
        this.maxNumberShip = maxNumberShip;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getTotalPv() {
        return totalPv;
    }

    public void setTotalPv(Integer totalPv) {
        this.totalPv = totalPv;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
       
}
