package com.iut.rodez.Recipes.repository;

import com.iut.rodez.Recipes.model.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface IngredientsRepository extends CrudRepository<Ingredients, String> {
}
