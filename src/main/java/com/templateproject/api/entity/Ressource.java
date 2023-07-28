package com.templateproject.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private int maxStock;

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

    // public String getRessourceName() {
    //     return null;
    // }

    // public void setRessourceName(String ressourceName) {
    // }

    // public Object getRessourceQuantity() {
    //     return null;
    // }

    // public void setRessourceQuantity(Object ressourceQuantity) {
    // }

    // public Object getNumberMaxPlayers() {
    //     return null;
    // }


}
