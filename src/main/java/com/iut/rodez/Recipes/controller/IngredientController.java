package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Ingredient;
import com.iut.rodez.Recipes.model.IngredientRequest;
import com.iut.rodez.Recipes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getIngredients(@RequestParam(value = "name") String name,
                                           @RequestParam(value = "category") List<String> ids_category) {
        return ingredientService.getIngredients(name, ids_category);
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Optional<Ingredient>> getIngredientsById(@PathVariable("id") String id) {
        return ingredientService.getIngredientById(id);
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> postIngredient(@RequestBody IngredientRequest ingredientRequest) {
        return ingredientService.postIngredient(ingredientRequest);
    }

    @DeleteMapping("/ingredients/{id}")
    public ResponseEntity<HttpStatus> deleteIngredient(@PathVariable String id) {
        return ingredientService.deleteIngredient(id);
    }

    @PutMapping("ingredients/{id}")
    public ResponseEntity<Ingredient> putIngredient(@RequestBody IngredientRequest ingredientRequest,@PathVariable String id) {
        return ingredientService.putIngredient(ingredientRequest, id);
    }
}
