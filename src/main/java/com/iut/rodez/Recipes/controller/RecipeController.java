package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Recipes;
import com.iut.rodez.Recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipes> getRecipes(@RequestParam(value = "name", required = false) String name) {
        return recipeService.getRecipes(name);
    }

    @GetMapping("/recipes/{id}")
    public Optional<Recipes> getRecipesById(@PathVariable("id") String id) {
        return recipeService.getRecipeById(id);
    }
}
