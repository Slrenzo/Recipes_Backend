package com.iut.rodez.Recipes.model;

import javax.persistence.*;

@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_recipe;

    private String name;

    private int time;

    @OneToOne
    @JoinColumn(name = "type")
    private TypeRecipe type;

    public String getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(String id_recipe) {
        this.id_recipe = id_recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public TypeRecipe getType() {
        return type;
    }

    public void setType(TypeRecipe type) {
        this.type = type;
    }
}
