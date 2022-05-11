package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Ingredients;
import com.iut.rodez.Recipes.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
public class IngredientsService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public List<Ingredients> getIngredients(String name, String id_category) {
        List<Ingredients> ingredients = new ArrayList<>();
        ingredientsRepository.findAll().forEach(ingredient -> {
            ingredients.add(ingredient);
        });
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getCategory().getId_category().equals(id_category))
                .filter(ingredient -> isBlank(name) || ingredient.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Ingredients> getIngredientByID(String id) {
        List<Ingredients> ingredients = new ArrayList<>();
        ingredientsRepository.findAll().forEach(ingredient -> {
            ingredients.add(ingredient);
        });
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getId_ingredient().equals(id))
                .findFirst();
    }

    public void postIngredient(Ingredients ingredient) {
        ingredientsRepository.save(ingredient);
    }

    public void deleteIngredient(String id) {
        ingredientsRepository.deleteById(id);
    }

    public void putIngredient(Ingredients ingredient, String id) {
        ingredientsRepository.save(ingredient);
    }
}
