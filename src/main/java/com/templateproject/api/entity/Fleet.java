package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Fleet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String name;
    private int maxNumberShip;
    private int positionX;
    private int positionY;
    private int power;
    private int totalPv;
    private int totalCapacity;
    private int speed;
    private int totalRange; 

    //JOINTS DECLARATION 
    @ManyToOne // Joint ToOrder 0.N-1.1 
    @JoinColumn (name = "player_id", nullable = false, referencedColumnName = "id") 
    private Player player;

    @ManyToMany //toPark O.N-O.N
    @JoinTable(
        name ="fleet_parked_planet",
        joinColumns = @JoinColumn(name = "fleet_id"),
        inverseJoinColumns = @JoinColumn(name="planet_id")        
    )
    private List<Planet> parkedPlanets;

    @ManyToMany (mappedBy = "fleetCompose")
    private List<Ship> shipToComposeFleet;

    public Fleet() {
    };

    public Fleet(String name, int maxNumberShip, int positionX, int positionY, int power, int totalPv,
            int totalCapacity, int speed, int totalRange) {
        this.name = name;
        this.maxNumberShip = maxNumberShip;
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = power;
        this.totalPv = totalPv;
        this.totalCapacity = totalCapacity;
        this.speed = speed;
        this.totalRange = totalRange;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTotalRange() {
        return totalRange;
    }

    public void setTotalRange(int totalRange) {
        this.totalRange = totalRange;
    }
//GETTERS & SETTER to Joint 

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Planet> getParkedPlanets() {
        return parkedPlanets;
    }

    public void setParkedPlanets(List<Planet> parkedPlanets) {
        this.parkedPlanets = parkedPlanets;
    }

    public List<Ship> getShipToComposeFleet() {
        return shipToComposeFleet;
    }

    public void setShipToComposeFleet(List<Ship> shipToComposeFleet) {
        this.shipToComposeFleet = shipToComposeFleet;
    }


}
