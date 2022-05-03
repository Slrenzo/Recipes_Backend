package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.IngredientMeasure;
import com.iut.rodez.Recipes.service.IngredientMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class IngredientMeasureController {

    @Autowired
    private IngredientMeasureService ingredientMeasureService;

    @GetMapping("/measures")
    public List<IngredientMeasure> getIngredientsMeasures() {
        return ingredientMeasureService.getIngredientsMeasures();
    }
}
