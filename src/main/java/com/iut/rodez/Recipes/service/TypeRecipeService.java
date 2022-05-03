package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.TypeRecipe;
import com.iut.rodez.Recipes.repository.TypeRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeRecipeService {

    @Autowired
    private TypeRecipeRepository typeRecipeRepository;

    public List<TypeRecipe> getTypesRecipe() {
        List typesRecipe = new ArrayList<>();
        typeRecipeRepository.findAll().forEach(type -> {
            typesRecipe.add(type);
        });
        return typesRecipe;
    }
}
