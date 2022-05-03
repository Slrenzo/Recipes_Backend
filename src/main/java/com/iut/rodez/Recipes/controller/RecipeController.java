package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Recipes;
import com.iut.rodez.Recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipes> getRecipes(@RequestParam(value = "name", required = false) String name) {
        return recipeService.getRecipes(name);
    }
}
