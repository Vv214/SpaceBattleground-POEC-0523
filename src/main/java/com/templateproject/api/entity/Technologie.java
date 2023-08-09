package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Technologie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 

    @Column(unique = true, nullable = false)
    private String name;
    private int ironPrice;
    private int diamondPrice;
    private int hydrogenPrice;
    private int priceEnergy;
    private String description; 
    private int lvl; 
    private float coef_modifier;
    private int timeSearch;
    private boolean isDone;

    //JOINT DECLARATION 
    @ManyToMany (mappedBy = "technologiesList") //Joints toUnlock 0.N-0.N
    private List<Ship> ships; 

    @ManyToMany// toAcces 0.N-0.N
    @JoinTable(
        name = "technologie_building",
        joinColumns = @JoinColumn (name = "technoligie_id"),
        inverseJoinColumns =  @JoinColumn(name ="building_id")
    )
    private List<Building> buildingsList;

    public Technologie() {};

    public Technologie(String name, int ironPrice, int diamondPrice, int hydrogenPrice, int priceEnergy,
                        String description, int lvl, float coef_modifier, int timeSearch, boolean isDone) {
        this.name = name;
        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice = hydrogenPrice;
        this.priceEnergy = priceEnergy;
        this.description = description;
        this.lvl = lvl;
        this.coef_modifier = coef_modifier;
        this.timeSearch = timeSearch;
        this.isDone = isDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public float getCoef_modifier() {
        return coef_modifier;
    }

    public void setCoef_modifier(float coef_modifier) {
        this.coef_modifier = coef_modifier;
    }

    public int getTimeSearch() {
        return timeSearch;
    }

    public void setTimeSearch(int timeSearch) {
        this.timeSearch = timeSearch;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
 //GETTERS & SETTERS to JOINTS




}
