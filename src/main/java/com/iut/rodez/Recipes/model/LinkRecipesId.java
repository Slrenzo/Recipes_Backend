package com.iut.rodez.Recipes.model;

import java.io.Serializable;
import java.util.Objects;

public class LinkRecipesId implements Serializable {

    private Recipes recipes;

    private Ingredients ingredients;

    public LinkRecipesId() {}

    public LinkRecipesId(Recipes recipes, Ingredients ingredients) {
        this.recipes = recipes;
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkRecipesId that = (LinkRecipesId) o;
        return Objects.equals(recipes, that.recipes) && Objects.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipes, ingredients);
    }
}
