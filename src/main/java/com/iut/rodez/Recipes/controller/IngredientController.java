package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Ingredient;
import com.iut.rodez.Recipes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/ingredients")
    public List<Ingredient> getIngredients(@RequestParam(value = "name", required = false) String name,
                                           @RequestParam(value = "category", required = false) List<String> ids_category) {
        return ingredientService.getIngredients(name, ids_category);
    }

    @GetMapping("/ingredients/{id}")
    public Optional<Ingredient> getIngredientsByID(@PathVariable("id") String id) {
        return ingredientService.getIngredientByID(id);
    }

    @PostMapping("/ingredients")
    public void postIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.postIngredient(ingredient);
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredient(@PathVariable String id) {
        ingredientService.deleteIngredient(id);
    }

    @PutMapping("ingredients/{id}")
    public void putIngredient(@RequestBody Ingredient ingredient,@PathVariable String id) {
        ingredientService.putIngredient(ingredient, id);
    }
}
