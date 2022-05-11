package com.iut.rodez.Recipes.model;

import javax.persistence.*;

@Entity
public class IngredientMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_ingredient_measure;

    @OneToOne
    @JoinColumn(name = "code_ingredient")
    private Ingredient ingredients;

    private double quantity;

    @OneToOne
    @JoinColumn(name = "units")
    private Unit units;

    public String getId_ingredient_measure() {
        return id_ingredient_measure;
    }

    public void setId_ingredient_measure(String id_ingredient_measure) {
        this.id_ingredient_measure = id_ingredient_measure;
    }

    public Ingredient getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient ingredients) {
        this.ingredients = ingredients;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Unit getUnits() {
        return units;
    }

    public void setUnits(Unit units) {
        this.units = units;
    }
}
