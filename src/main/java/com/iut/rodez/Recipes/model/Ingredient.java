package com.iut.rodez.Recipes.model;

import net.bytebuddy.utility.RandomString;

import javax.persistence.*;

@Entity
public class Ingredient {

    @PrePersist
    private void ensureId(){
        this.setId(RandomString.make(15));
    }
    @Id
    private String id;

    private String name;


    @OneToOne
    @JoinColumn(name = "id_category")
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
