package com.iut.rodez.Recipes.model;


import net.bytebuddy.utility.RandomString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @PrePersist
    private void ensureId(){
        this.setId(RandomString.make(15));
    }

    @Id
    private String id;

    private String name;

    private int time;

    @OneToOne
    @JoinColumn(name = "id_type")
    private Type type;

    @OneToMany
    @JoinTable(name = "link_recipe",
              joinColumns = @JoinColumn(name = "id_recipe"),
              inverseJoinColumns = @JoinColumn(name = "id_ingredient_measure"))
    private List<Ingredients> ingredients = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id_recipe")
    private List<Step> steps = new ArrayList<>();

    private int number_person;

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

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
