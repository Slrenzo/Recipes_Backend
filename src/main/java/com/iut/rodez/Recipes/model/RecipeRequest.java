package com.iut.rodez.Recipes.model;

import java.util.List;

public class RecipeRequest {

    private String name;

    private int people;

    private int time;

    private String image;

    private String typeId;

    private List<IngredientsRequest> ingredients;

    private List<Step> steps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public List<IngredientsRequest> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsRequest> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
