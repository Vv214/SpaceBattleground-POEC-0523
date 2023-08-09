package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    private int ironPrice;
    private int diamondPrice;
    private int hydrogenPrice;
    private int priceEnergy;
    private int pv;
    private int damage;
    private int fuel;
    private int speed;
    private int range;
    private int capacity;
    private int shipSize;
    private int quantity;

    //JOINT DECLARATION
    @ManyToMany
    @JoinTable(
        name = "ship_toCompose_fleet",
        joinColumns = @JoinColumn(name="ship_id"),
        inverseJoinColumns = @JoinColumn(name="fleet_id")
    )
    private List<Fleet> fleetCompose;

    @OneToMany(mappedBy="ship")//toMake 1.N-0.N
    private List<Building> buildingNecessary; 

    // @OneToMany (mappedBy = "ship") //Joints toUnlock 0.N-0.N
    @ManyToMany
    @JoinTable(
        name ="ship_technologie",
        joinColumns = @JoinColumn(name="ship_id"),
        inverseJoinColumns = @JoinColumn(name="technologie_id")
    )
    private List<Technologie> technologiesList; 

    public Ship() {
    };

    public Ship(String name, String type, int ironPrice,
            int diamondPrice, int hydrogenPrice,
            int priceEnergy, int pv, int damage,
            int fuel, int speed, int range,
            int capacity, int shipSize, int quantity) {

        this.name = name;
        this.type = type;
        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice = hydrogenPrice;
        this.priceEnergy = priceEnergy;
        this.pv = pv;
        this.damage = damage;
        this.fuel = fuel;
        this.speed = speed;
        this.range = range;
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

    public int getIronPrice() {
        return ironPrice;
    }

    public void setIronPrice(int ironPrice) {
        this.ironPrice = ironPrice;
    }

    public int getDiamondPrice() {
        return diamondPrice;
    }

    public void setDiamondPrice(int diamondPrice) {
        this.diamondPrice = diamondPrice;
    }

    public int getHydrogenPrice() {
        return hydrogenPrice;
    }

    public void setHydrogenPrice(int hydrogenPrice) {
        this.hydrogenPrice = hydrogenPrice;
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
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
    public void setPv(int pv) {
        this.pv = pv;
    }
//GETTER & SETTER to JKOINTS

    public List<Fleet> getFleetCompose() {
        return fleetCompose;
    }

    public void setFleetCompose(List<Fleet> fleetCompose) {
        this.fleetCompose = fleetCompose;
    }

    public List<Building> getBuildingNecessary() {
        return buildingNecessary;
    }

    public void setBuildingNecessary(List<Building> buildingNecessary) {
        this.buildingNecessary = buildingNecessary;
    }

    public List<Technologie> getTechnologiesList() {
        return technologiesList;
    }

    public void setTechnologiesList(List<Technologie> technologiesList) {
        this.technologiesList = technologiesList;
    }


}
