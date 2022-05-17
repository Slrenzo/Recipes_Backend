package com.iut.rodez.Recipes.model;


import net.bytebuddy.utility.RandomString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @PrePersist
    private void ensureId(){
        this.setId_recipe(RandomString.make(15));
    }

    @Id
    private String id_recipe;

    private String name;

    private int time;

    @OneToOne
    @JoinColumn(name = "type")
    private TypeRecipe type;

    @OneToMany
    @JoinTable(name = "link_recipe",
              joinColumns = @JoinColumn(name = "code_recipe"),
              inverseJoinColumns = @JoinColumn(name = "code_ingredient_measure"))
    private List<IngredientMeasure> ingredientsMeasures = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id_step_recipe")
    private List<Step> steps = new ArrayList<>();

    private int number_person;

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

    public List<IngredientMeasure> getIngredientsMeasures() {
        return ingredientsMeasures;
    }

    public void setIngredientsMeasures(List<IngredientMeasure> ingredientsMeasures) {
        this.ingredientsMeasures = ingredientsMeasures;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public int getNumber_person() {
        return number_person;
    }

    public void setNumber_person(int number_person) {
        this.number_person = number_person;
    }
}
