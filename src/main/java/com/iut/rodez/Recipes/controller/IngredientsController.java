package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Ingredients;
import com.iut.rodez.Recipes.model.Recipes;
import com.iut.rodez.Recipes.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping("/ingredients")
    public List<Ingredients> getIngredients(@RequestParam(value = "name", required = false) String name,
                                            @RequestParam(value = "categoryIn", required = false) String id_category) {
        return ingredientsService.getIngredients(name, id_category);
    }

    @GetMapping("/ingredients/{id}")
    public Optional<Ingredients> getIngredientsByID(@PathVariable("id") String id) {
        return ingredientsService.getIngredientByID(id);
    }

    @PostMapping("/ingredients")
    public void postIngredient(@RequestBody Ingredients ingredient) {
        ingredientsService.postIngredient(ingredient);
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredient(@PathVariable String id) {
        ingredientsService.deleteIngredient(id);
    }

    @PutMapping("ingredients/{id}")
    public void putIngredient(@RequestBody Ingredients ingredient,@PathVariable String id) {
        ingredientsService.putIngredient(ingredient, id);
    }
}
