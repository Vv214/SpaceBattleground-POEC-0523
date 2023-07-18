package com.templateproject.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int hydrogeneTotal;
    private int ferTotal;
    private int diamantTotal;
    private int hydrogeneInStock;
    private int ferInStock;
    private int diamantInStock;
    private boolean isColonised;
    private int positionX;
    private int positionY;
    private int planetSize;

    public Planet() {
    };

    public Planet(String name, int hydrogeneTotal, int ferTotal, int diamantTotal, int hydrogeneInStock,
            int ferInStock, int diamantInStock, boolean isColonised, int positionX, int positionY, int planetSize) {
        this.name = name;
        this.hydrogeneTotal = hydrogeneTotal;
        this.ferTotal = ferTotal;
        this.diamantTotal = diamantTotal;
        this.hydrogeneInStock = hydrogeneInStock;
        this.ferInStock = ferInStock;
        this.diamantInStock = diamantInStock;
        this.isColonised = isColonised;
        this.positionX = positionX;
        this.positionY = positionY;
        this.planetSize = planetSize;
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

    public int getHydrogeneTotal() {
        return hydrogeneTotal;
    }

    public void setHydrogeneTotal(int hydrogeneTotal) {
        this.hydrogeneTotal = hydrogeneTotal;
    }

    public int getFerTotal() {
        return ferTotal;
    }

    public void setFerTotal(int ferTotal) {
        this.ferTotal = ferTotal;
    }

    public int getDiamantTotal() {
        return diamantTotal;
    }

    public void setDiamantTotal(int diamantTotal) {
        this.diamantTotal = diamantTotal;
    }

    public int getHydrogeneInStock() {
        return hydrogeneInStock;
    }

    public void setHydrogeneInStock(int hydrogeneInStock) {
        this.hydrogeneInStock = hydrogeneInStock;
    }

    public int getFerInStock() {
        return ferInStock;
    }

    public void setFerInStock(int ferInStock) {
        this.ferInStock = ferInStock;
    }

    public int getDiamantInStock() {
        return diamantInStock;
    }

    public void setDiamantInStock(int diamantInStock) {
        this.diamantInStock = diamantInStock;
    }

    public boolean isColonised() {
        return isColonised;
    }

    public void setColonised(boolean isColonised) {
        this.isColonised = isColonised;
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

    public int getPlanetSize() {
        return planetSize;
    }

    public void setPlanetSize(int planetSize) {
        this.planetSize = planetSize;
    }

}
