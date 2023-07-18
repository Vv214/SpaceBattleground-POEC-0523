package com.templateproject.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Admin(int id) {
        this.id = id;
    }

    public void banPlayer(String player) {

    }

    public void deletePlayer(String player) {

    }

    public void giveRessources(String name) {

    }

    public void removeRessources(String name) {

    }
}
