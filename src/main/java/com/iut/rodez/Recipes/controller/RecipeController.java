package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Recipe;
import com.iut.rodez.Recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/")
    public List<Recipe> getRecipeForHomepage() {
        return recipeService.getRecipeForHomepage();
    }

    @GetMapping("/recipes")
    public List<Recipe> getRecipes(@RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "type", required = false) String id_type_recipe) {
        return recipeService.getRecipes(name, id_type_recipe);
    }

    @GetMapping("/recipes/{id}")
    public Optional<Recipe> getRecipesById(@PathVariable("id") String id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping("/recipes")
    public void postRecipe(@RequestBody Recipe recipe) {
        recipeService.postRecipe(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable String id) {
        recipeService.deleteRecipe(id);
    }

    @PutMapping("recipes/{id}")
    public void putRecipe(@RequestBody Recipe recipe,@PathVariable String id) {
        recipeService.putRecipe(recipe, id);
    }
}
