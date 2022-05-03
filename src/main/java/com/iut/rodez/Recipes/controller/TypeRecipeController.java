package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.TypeRecipe;
import com.iut.rodez.Recipes.service.TypeRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeRecipeController {

    @Autowired
    private TypeRecipeService typeRecipeService;

    @GetMapping("/types_recipe")
    public List<TypeRecipe> getTypesRecipe() {
        return typeRecipeService.getTypesRecipe();
    }
}
