package com.iut.rodez.Recipes.repository;

import com.iut.rodez.Recipes.model.Step;
import org.springframework.data.repository.CrudRepository;

public interface StepRepository extends CrudRepository<Step, String> {
}
