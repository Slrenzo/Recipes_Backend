package com.iut.rodez.Recipes.repository;

import com.iut.rodez.Recipes.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {
}
