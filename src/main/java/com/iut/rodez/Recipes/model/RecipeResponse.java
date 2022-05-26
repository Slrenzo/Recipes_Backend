package com.iut.rodez.Recipes.model;

import java.util.List;

public class RecipeResponse {

    private String id;

    private String name;

    private int time;

    private Type type;

    private List<IngredientsResponse> ingredients;

    private List<Step> steps;

    private int people;

    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<IngredientsResponse> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsResponse> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
