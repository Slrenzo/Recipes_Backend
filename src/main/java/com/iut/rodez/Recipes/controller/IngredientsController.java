package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Ingredients;
import com.iut.rodez.Recipes.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping("/ingredients")
    public List<Ingredients> getIngredients(@RequestParam(value = "name", required = false) String name) {
        return ingredientsService.getIngredients(name);
    }

    @GetMapping("/ingredients/{id_category}")
    public List<Ingredients> getIngredientsByCategory(@PathVariable("id_category") String id_category) {
        return ingredientsService.getIngredientsByCategory(id_category);
    }
}
