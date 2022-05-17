package com.iut.rodez.Recipes.model;

import net.bytebuddy.utility.RandomString;

import javax.persistence.*;

@Entity
public class Unit {

    @PrePersist
    private void ensureId(){
        this.setId_unit(RandomString.make(15));
    }

    @Id
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
