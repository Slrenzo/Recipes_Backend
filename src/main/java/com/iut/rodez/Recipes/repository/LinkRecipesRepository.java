package com.iut.rodez.Recipes.repository;

import com.iut.rodez.Recipes.model.LinkRecipes;
import com.iut.rodez.Recipes.model.LinkRecipesId;
import com.iut.rodez.Recipes.model.Recipes;
import org.springframework.data.repository.CrudRepository;

public interface LinkRecipesRepository extends CrudRepository<LinkRecipes, LinkRecipesId> {
}
