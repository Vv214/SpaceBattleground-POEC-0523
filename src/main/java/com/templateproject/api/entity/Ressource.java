package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.*;


@Entity
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column( unique = true, nullable = false, length = 50)
    private String name;

    private Integer quantity;
    private Integer maxStock;

    //JOINT DECLARATION
    @ManyToMany(mappedBy="ressourcesList")
    private List<Planet> planetToStore;

    @OneToOne(mappedBy="ressource")
    private Building building;

    public Ressource() {
    }

    public Ressource(String name, Integer quantity, Integer maxStock) {
        this.name = name;
        this.quantity = quantity;
        this.maxStock = maxStock;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
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
