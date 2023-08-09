package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.*;


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
