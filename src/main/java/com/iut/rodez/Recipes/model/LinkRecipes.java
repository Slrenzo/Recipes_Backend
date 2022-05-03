package com.iut.rodez.Recipes.model;

import javax.persistence.*;

@Entity
@IdClass(LinkRecipesId.class)
public class LinkRecipes {

    @Id
    @OneToOne
    @JoinColumn(name = "code_recipe")
    private Recipes recipes;

    @Id
    @OneToOne
    @JoinColumn(name = "code_ingredient")
    private Ingredients ingredients;

    private double quantity;

    @OneToOne
    @JoinColumn(name = "units")
    private Units units;

    public Recipes getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipes recipes) {
        this.recipes = recipes;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }
}
