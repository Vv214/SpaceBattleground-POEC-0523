package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.OneToOne;

@Entity
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int quantity;
    private int maxStock;

    //JOINT DECLARATION
    @ManyToMany(mappedBy="ressourcesList")
    private List<Planet> planetToStore;

    @OneToOne(mappedBy="ressource")
    private Building building;

    public Ressource() {
    }

    public Ressource(String name, int quantity, int maxStock) {
        this.name = name;
        this.quantity = quantity;
        this.maxStock = maxStock;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public void setId(int id) {
        this.id = id;
    }
    //GETTER & SETTER to JOINTS
    public List<Planet> getPlanetToStore() {
        return planetToStore;
    }

    public void setPlanetToStore(List<Planet> planetToStore) {
        this.planetToStore = planetToStore;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

   


}
