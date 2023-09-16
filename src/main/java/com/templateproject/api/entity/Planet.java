package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 50)
    private String name;
    private boolean isColonised;
    private Integer positionX;
    private Integer positionY;
    private Integer planetSize;

    // JOINT DECLARATION
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = true, referencedColumnName = "id")
    private Player player;

    @OneToMany(mappedBy = "planet")
    private List<Building> buildings;

    public Planet() {
    };

    public Planet(String name, boolean isColonised, Integer positionX, Integer positionY, Integer planetSize,
            Player player) {
        this.name = name;
        this.isColonised = isColonised;
        this.positionX = positionX;
        this.positionY = positionY;
        this.planetSize = planetSize;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isColonised() {
        return isColonised;
    }

    public void setColonised(boolean isColonised) {
        this.isColonised = isColonised;
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

    public Integer getPlanetSize() {
        return planetSize;
    }

    public void setPlanetSize(Integer planetSize) {
        this.planetSize = planetSize;
    }

    // GETTER & SETTER to JOINT
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

}
