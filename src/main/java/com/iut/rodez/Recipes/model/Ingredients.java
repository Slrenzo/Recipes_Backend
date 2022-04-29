package com.iut.rodez.Recipes.model;

import net.bytebuddy.description.type.TypeList;

import javax.persistence.*;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id_ingredient;

    private String name;

    @OneToOne
    @JoinColumn(name = "category")
    private Category category;

    public String getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(String id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
