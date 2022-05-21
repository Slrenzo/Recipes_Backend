package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Ingredient;
import com.iut.rodez.Recipes.model.IngredientRequest;
import com.iut.rodez.Recipes.repository.CategoryRepository;
import com.iut.rodez.Recipes.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Ingredient> getIngredients(String name, List<String> ids_category) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        if (name == null || ids_category == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ingredients
                .stream()
                .filter(ingredient -> ids_category.isEmpty()
                                      || ids_category.contains(ingredient.getCategory().getId()))
                .filter(ingredient -> isBlank(name) || ingredient.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Ingredient> getIngredientById(String id) {
        if (!ingredientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ingredientRepository.findById(id);
    }

    public ResponseEntity<HttpStatus> postIngredient(IngredientRequest ingredientRequest) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        List<String> names = new ArrayList<>();
        ingredients.forEach(ingredient -> names.add(ingredient.getName()));
        if (!categoryRepository.existsById(ingredientRequest.getCategoryId())
            || names.contains(ingredientRequest.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientRequest.getName());
        ingredient.setCategory(categoryRepository.findById(ingredientRequest.getCategoryId()).get());
        ingredient.setImage(ingredientRequest.getImage());
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<HttpStatus> deleteIngredient(String id) {
        if (!ingredientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        ingredientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> putIngredient(IngredientRequest ingredientRequest, String id) {
        if (!ingredientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Ingredient ingredient = ingredientRepository.findById(id).get();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        List<String> names = new ArrayList<>();
        ingredients.forEach(ingredient1 -> names.add(ingredient1.getName()));
        if (!categoryRepository.existsById(ingredientRequest.getCategoryId())
            || (!ingredient.getName().equals(ingredientRequest.getName())
                && names.contains(ingredientRequest.getName()))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        ingredient.setName(ingredientRequest.getName());
        ingredient.setCategory(categoryRepository.findById(ingredientRequest.getCategoryId()).get());
        ingredient.setImage(ingredientRequest.getImage());
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
