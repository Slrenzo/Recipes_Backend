package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.IngredientMeasure;
import com.iut.rodez.Recipes.model.IngredientMeasureRequest;
import com.iut.rodez.Recipes.service.IngredientMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class IngredientMeasureController {

    @Autowired
    private IngredientMeasureService ingredientMeasureService;

    @GetMapping("/measures")
    public List<IngredientMeasure> getIngredientsMeasures() {
        return ingredientMeasureService.getIngredientsMeasures();
    }

    @GetMapping("/measures/{id}")
    public Optional<IngredientMeasure> getIngredientsMeasures(@PathVariable String id) {
        return ingredientMeasureService.getIngredientMeasureById(id);
    }

    @PostMapping("/measures")
    public ResponseEntity<HttpStatus> postIngredientMeasure(@RequestBody IngredientMeasureRequest ingredientMeasureRequest) {
        return ingredientMeasureService.postIngredientMeasure(ingredientMeasureRequest);
    }

    @DeleteMapping("/measures/{id}")
    public ResponseEntity<HttpStatus> deleteIngredientMeasure(@PathVariable String id) {
        return ingredientMeasureService.deleteIngredientMeasure(id);
    }

    @PutMapping("/measures/{id}")
    public ResponseEntity<HttpStatus> putIngredientMeasure(@RequestBody IngredientMeasureRequest ingredientMeasureRequest, @PathVariable String id) {
        return ingredientMeasureService.putIngredientMeasure(ingredientMeasureRequest, id);
    }
}
