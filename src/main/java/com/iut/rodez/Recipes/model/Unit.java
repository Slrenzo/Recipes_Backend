package com.iut.rodez.Recipes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_unit;

    private String name;

    public String getId_unit() {
        return id_unit;
    }

    public void setId_unit(String id_unit) {
        this.id_unit = id_unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
