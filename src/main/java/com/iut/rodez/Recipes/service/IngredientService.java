package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Ingredient;
import com.iut.rodez.Recipes.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getIngredients(String name, String id_category) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients
                .stream()
                .filter(ingredient -> isBlank(id_category) || ingredient.getCategory().getId_category().equals(id_category))
                .filter(ingredient -> isBlank(name) || ingredient.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Ingredient> getIngredientByID(String id) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getId_ingredient().equals(id))
                .findFirst();
    }

    public void postIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(String id) {
        ingredientRepository.deleteById(id);
    }

    public void putIngredient(Ingredient ingredient, String id) {
        ingredientRepository.save(ingredient);
    }
}
