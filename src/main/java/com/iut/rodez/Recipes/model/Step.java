package com.iut.rodez.Recipes.model;

import javax.persistence.*;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_step;

    @OneToOne
    @JoinColumn(name = "id_step_recipe")
    private Recipes recipes;

    private String descr;

    private int step_order;

    public String getId_step() {
        return id_step;
    }

    public void setId_step(String id_step) {
        this.id_step = id_step;
    }

    public Recipes getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipes recipes) {
        this.recipes = recipes;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getStep_order() {
        return step_order;
    }

    public void setStep_order(int step_order) {
        this.step_order = step_order;
    }
}
