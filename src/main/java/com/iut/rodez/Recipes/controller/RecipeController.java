package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Recipes;
import com.iut.rodez.Recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipes> getRecipes() {
        return recipeService.getRecipes();
    }
}
