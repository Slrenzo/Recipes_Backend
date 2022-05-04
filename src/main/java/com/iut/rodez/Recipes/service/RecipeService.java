package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Recipes;
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

    public List<Recipes> getRecipes(String name) {
        List<Recipes> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipe -> {
            recipes.add(recipe);
        });
        recipes
                .stream()
                .forEach(recipe -> {
                    List<Step> steps = new ArrayList<>(recipe.getSteps());
                    recipe
                            .getSteps()
                            .stream()
                            .forEach(step -> {
                                steps.set(step.getStep_order() - 1, step);
                            });
                    recipe.setSteps(steps);
                });
        return recipes
                .stream()
                .filter(recipe -> isBlank(name) || recipe.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Recipes> getRecipeById(String id) {
        List<Recipes> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipe -> {
            recipes.add(recipe);
        });
        recipes
                .stream()
                .forEach(recipe -> {
                    List<Step> steps = new ArrayList<>(recipe.getSteps());
                    recipe
                            .getSteps()
                            .stream()
                            .forEach(step -> {
                                steps.set(step.getStep_order() - 1, step);
                            });
                    recipe.setSteps(steps);
                });
        return recipes
                .stream()
                .filter(recipe -> recipe.getId_recipe().equals(id))
                .findFirst();
    }
}
