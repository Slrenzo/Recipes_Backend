package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.*;
import com.iut.rodez.Recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientsService ingredientsService;

    public List<RecipeShortResponse> getRecipes(String name, List<String> ids_type_recipe) {
        List<Recipe> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipes::add);
        recipes = recipes
                .stream()
                .filter(recipe -> ids_type_recipe.isEmpty() || ids_type_recipe.contains(recipe.getType().getId()))
                .filter(recipe -> isBlank(name) || recipe.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        List<RecipeShortResponse> recipeShortResponses = new ArrayList<>();
        recipes.forEach(recipe -> {
            RecipeShortResponse recipeShortResponse = new RecipeShortResponse();
            recipeShortResponse.setId(recipe.getId());
            recipeShortResponse.setName(recipe.getName());
            recipeShortResponse.setTime(recipe.getTime());
            recipeShortResponse.setImage(recipe.getImage());
            recipeShortResponses.add(recipeShortResponse);
        });
        return recipeShortResponses;
    }

    public RecipeResponse getRecipeById(String id) {
        if (!recipeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Recipe recipe = recipeRepository.findById(id).get();
        RecipeResponse recipeResponse = new RecipeResponse();
        recipeResponse.setId(recipe.getId());
        recipeResponse.setName(recipe.getName());
        recipeResponse.setTime(recipe.getTime());
        recipeResponse.setType(recipe.getType());
        List<IngredientsResponse> ingredients = new ArrayList<>();
        recipe.getIngredients().forEach(ing -> {
            ingredients.add(ingredientsService.getIngredientsById(ing.getId()));
        });
        recipeResponse.setIngredients(ingredients);
        List<Step> steps = new ArrayList<>(recipe.getSteps());
        recipe.getSteps().forEach(step -> {
            steps.set(step.getStep_order() - 1, step);
        });
        recipeResponse.setSteps(steps);
        recipeResponse.setPeople(recipe.getNumber_person());
        recipeResponse.setImage(recipe.getImage());
        return  recipeResponse;
    }

    public void postRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(String id) {
        recipeRepository.deleteById(id);
    }

    public void putRecipe(Recipe recipe, String id) {
        recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipeForHomepage() {
        List<Recipe> allRecipes = new ArrayList<>();
        recipeRepository.findAll().forEach(allRecipes::add);
        List<Recipe> recipes = new ArrayList<>(0);
        while (recipes.size() < 8 && recipes.size() < allRecipes.size()) {
            recipes.add(allRecipes.get(recipes.size()));
        }
        return recipes;
    }
}
