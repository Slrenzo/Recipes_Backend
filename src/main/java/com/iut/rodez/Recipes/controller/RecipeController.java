package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.RecipeRequest;
import com.iut.rodez.Recipes.model.RecipeResponse;
import com.iut.rodez.Recipes.model.RecipeShortResponse;
import com.iut.rodez.Recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/")
    public ResponseEntity<List<RecipeShortResponse>> getRecipeForHomepage() {
        return recipeService.getRecipeForHomepage();
    }

    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeShortResponse>> getRecipes(@RequestParam(value = "name") String name,
                                                @RequestParam(value = "type") List<String> ids_type_recipe) {
        return recipeService.getRecipes(name, ids_type_recipe);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<RecipeResponse> getRecipesById(@PathVariable("id") String id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping("/recipes")
    public ResponseEntity<RecipeResponse> postRecipe(@RequestBody RecipeRequest recipeRequest) {
        return recipeService.postRecipe(recipeRequest);
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable String id) {
        return recipeService.deleteRecipe(id);
    }

    @PutMapping("recipes/{id}")
    public ResponseEntity<RecipeResponse> putRecipe(@RequestBody RecipeRequest recipeRequest,@PathVariable String id) {
        return recipeService.putRecipe(recipeRequest, id);
    }
}
