package com.iut.rodez.Recipes.model;

import net.bytebuddy.utility.RandomString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Ingredient {

    @PrePersist
    private void ensureId(){
        this.setId_ingredient(RandomString.make(15));
    }
    @Id
    private String id_ingredient;

    private String name;

    @OneToOne
    @JoinColumn(name = "category")
    private Category category;

    public String getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(String id_ingredient) {
        this.id_ingredient = id_ingredient;
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
}
