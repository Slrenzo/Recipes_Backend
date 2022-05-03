package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Ingredients;
import com.iut.rodez.Recipes.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
