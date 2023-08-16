package com.templateproject.api.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Technologie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false, length = 50)
    private String name;
    private String description;

    private Integer ironPrice;
    private Integer diamondPrice;
    private Integer hydrogenPrice;
    private Integer energyPrice;

    private Integer level;
    private float coef_modifier;
    private Date timeSearch;
    private boolean isDone;

    // JOINT DECLARATION
    @ManyToMany(mappedBy = "technologiesList") // Joints toUnlock 0.N-0.N
    private List<Ship> ships;

    @ManyToMany // toAcces 0.N-0.N
    @JoinTable(name = "technologie_building", joinColumns = @JoinColumn(name = "technoligie_id"), inverseJoinColumns = @JoinColumn(name = "building_id"))
    private List<Building> buildingsList;

    public Technologie() {
    };

    public Technologie(String name, String description, Integer ironPrice, Integer diamondPrice, Integer hydrogenPrice,
            Integer energyPrice, Integer level, float coef_modifier, Date timeSearch, boolean isDone) {
        this.name = name;
        this.description = description;
        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice = hydrogenPrice;
        this.energyPrice = energyPrice;
        this.level = level;
        this.coef_modifier = coef_modifier;
        this.timeSearch = timeSearch;
        this.isDone = isDone;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setEnergyPrice(Integer energyPrice) {
        this.energyPrice = energyPrice;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public float getCoef_modifier() {
        return coef_modifier;
    }

    public void setCoef_modifier(float coef_modifier) {
        this.coef_modifier = coef_modifier;
    }

    public Date getTimeSearch() {
        return timeSearch;
    }

    public void setTimeSearch(Date timeSearch) {
        this.timeSearch = timeSearch;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    // GETTERS & SETTERS to JOINTS

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public List<Building> getBuildingsList() {
        return buildingsList;
    }

    public void setBuildingsList(List<Building> buildingsList) {
        this.buildingsList = buildingsList;
    }

}
