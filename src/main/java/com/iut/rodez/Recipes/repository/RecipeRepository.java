package com.iut.rodez.Recipes.repository;

import com.iut.rodez.Recipes.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
