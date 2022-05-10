package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.IngredientMeasure;
import com.iut.rodez.Recipes.service.IngredientMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/measures")
    public void postIngredientMeasure(@RequestBody IngredientMeasure ingredientMeasure) {
        ingredientMeasureService.postIngredientMeasure(ingredientMeasure);
    }

    @DeleteMapping("/measures/{id}")
    public void deleteIngredientMeasure(@PathVariable String id) {
        ingredientMeasureService.deleteIngredientMeasure(id);
    }

    @PutMapping("/measures/{id}")
    public void putIngredientMeasure(@RequestBody IngredientMeasure ingredientMeasure, @PathVariable String id) {
        ingredientMeasureService.putIngredientMeasure(ingredientMeasure, id);
    }
}
