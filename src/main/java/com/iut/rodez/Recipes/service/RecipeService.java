package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Recipe;
import com.iut.rodez.Recipes.model.Step;
import com.iut.rodez.Recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getRecipes(String name, String id_type_recipe) {
        List<Recipe> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipes::add);
        recipes
                .forEach(recipe -> {
                    List<Step> steps = new ArrayList<>(recipe.getSteps());
                    recipe
                            .getSteps()
                            .forEach(step -> steps.set(step.getStep_order() - 1, step));
                    recipe.setSteps(steps);
                });
        return recipes
                .stream()
                .filter(recipe -> isBlank(id_type_recipe) || recipe.getType().getId_type().equals(id_type_recipe))
                .filter(recipe -> isBlank(name) || recipe.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Recipe> getRecipeById(String id) {
        List<Recipe> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipes::add);
        recipes
                .forEach(recipe -> {
                    List<Step> steps = new ArrayList<>(recipe.getSteps());
                    recipe
                            .getSteps()
                            .forEach(step -> steps.set(step.getStep_order() - 1, step));
                    recipe.setSteps(steps);
                });
        return recipes
                .stream()
                .filter(recipe -> recipe.getId_recipe().equals(id))
                .findFirst();
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
        List<Recipe> recipes = new ArrayList<>();
        while (recipes.size() < 8) {
            recipes.add(allRecipes.get(recipes.size()));
        }
        return recipes;
    }
}
