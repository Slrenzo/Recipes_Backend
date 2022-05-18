package com.iut.rodez.Recipes.model;

import net.bytebuddy.utility.RandomString;

import javax.persistence.*;

@Entity
public class IngredientMeasure {

    @PrePersist
    private void ensureId(){
        this.setId(RandomString.make(15));
    }

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;

    private double quantity;

    @OneToOne
    @JoinColumn(name = "id_unit")
    private Unit unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
