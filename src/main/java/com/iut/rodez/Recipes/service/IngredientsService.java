package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Category;
import com.iut.rodez.Recipes.model.Ingredients;
import com.iut.rodez.Recipes.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientsService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public List<Ingredients> getIngredients() {
        List<Ingredients> ingredients = new ArrayList<>();
        ingredientsRepository.findAll().forEach(ingredient -> {
            ingredients.add(ingredient);
        });
        return ingredients;
    }
}
