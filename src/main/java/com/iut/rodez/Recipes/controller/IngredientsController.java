package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.IngredientsRequest;
import com.iut.rodez.Recipes.model.IngredientsResponse;
import com.iut.rodez.Recipes.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping("/recipe-ingredients")
    public List<IngredientsResponse> getIngredients() {
        return ingredientsService.getIngredients();
    }

    @GetMapping("/recipe-ingredients/{id}")
    public IngredientsResponse getIngredientsById(@PathVariable String id) {
        return ingredientsService.getIngredientsById(id);
    }

    @PostMapping("/recipe-ingredients")
    public ResponseEntity<HttpStatus> postIngredients(@RequestBody IngredientsRequest ingredientsRequest) {
        return ingredientsService.postIngredients(ingredientsRequest);
    }

    @DeleteMapping("/recipe-ingredients/{id}")
    public ResponseEntity<HttpStatus> deleteIngredients(@PathVariable String id) {
        return ingredientsService.deleteIngredients(id);
    }

    @PutMapping("/recipe-ingredients/{id}")
    public ResponseEntity<HttpStatus> putIngredients(@RequestBody IngredientsRequest ingredientsRequest, @PathVariable String id) {
        return ingredientsService.putIngredients(ingredientsRequest, id);
    }
}
