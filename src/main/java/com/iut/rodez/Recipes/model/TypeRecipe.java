package com.iut.rodez.Recipes.model;

import net.bytebuddy.utility.RandomString;

import javax.persistence.*;

@Entity
public class TypeRecipe {

    @PrePersist
    private void ensureId(){
        this.setId_type(RandomString.make(2));
    }

    @Id
    private String id_type;

    private String name;

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
