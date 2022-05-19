package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Category;
import com.iut.rodez.Recipes.model.Ingredient;
import com.iut.rodez.Recipes.model.IngredientRequest;
import com.iut.rodez.Recipes.repository.CategoryRepository;
import com.iut.rodez.Recipes.repository.IngredientRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Ingredient> getIngredients(String name, List<String> ids_category) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients
                .stream()
                .filter(ingredient -> ids_category == null
                                      || ids_category.isEmpty()
                                      || ids_category.contains(ingredient.getCategory().getId()))
                .filter(ingredient -> isBlank(name) || ingredient.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Ingredient> getIngredientById(String id) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getId().equals(id))
                .findFirst();
    }

    public ResponseEntity<HttpStatus> postIngredient(IngredientRequest ingredientRequest) {
        Ingredient ingredient = new Ingredient();
        List<Category> categories;
        categories = categoryService.getCategories();
        List<String> categoryIds = new ArrayList<>();
        categories.forEach(category -> categoryIds.add(category.getId()));
        if (!categoryIds.contains(ingredientRequest.getCategoryId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        List<String> names = new ArrayList<>();
        ingredients.forEach(ingredient1 -> names.add(ingredient1.getName()));
        if (names.contains(ingredientRequest.getName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ingredient.setName(ingredientRequest.getName());
        ingredient.setCategory(categories.stream().filter(
                category -> category.getId().equals(ingredientRequest.getCategoryId())
        ).findFirst().get());
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public void deleteIngredient(String id) {
        ingredientRepository.deleteById(id);
    }

    public ResponseEntity<HttpStatus> putIngredient(IngredientRequest ingredientRequest, String id) {
        Ingredient ingredient = ingredientRepository.findById(id).get();
        List<Category> categories;
        categories = categoryService.getCategories();
        List<String> categoryIds = new ArrayList<>();
        categories.forEach(category -> categoryIds.add(category.getId()));
        if (!categoryIds.contains(ingredientRequest.getCategoryId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        List<String> names = new ArrayList<>();
        ingredients.forEach(ingredient1 -> names.add(ingredient1.getName()));
        if (names.contains(ingredientRequest.getName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ingredient.setName(ingredientRequest.getName());
        ingredient.setCategory(categories.stream().filter(
                category -> category.getId().equals(ingredientRequest.getCategoryId())
        ).findFirst().get());
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
