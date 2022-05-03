package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Category;
import com.iut.rodez.Recipes.model.Ingredients;
import com.iut.rodez.Recipes.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
public class IngredientsService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public List<Ingredients> getIngredients(String name) {
        List<Ingredients> ingredients = new ArrayList<>();
        ingredientsRepository.findAll().forEach(ingredient -> {
            ingredients.add(ingredient);
        });
        return ingredients
                .stream()
                .filter(ingredient -> isBlank(name) || ingredient.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
