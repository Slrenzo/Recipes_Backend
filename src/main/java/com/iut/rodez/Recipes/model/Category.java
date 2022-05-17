package com.iut.rodez.Recipes.model;

import net.bytebuddy.utility.RandomString;

import javax.persistence.*;

@Entity
public class Category {

    @PrePersist
    private void ensureId(){
        this.setId_category(RandomString.make(2));
    }

    @Id
    private String id_category;
    private String name;

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
