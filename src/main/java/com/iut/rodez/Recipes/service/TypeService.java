package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Type;
import com.iut.rodez.Recipes.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getTypesRecipe() {
        List<Type> typesRecipe = new ArrayList<>();
        typeRepository.findAll().forEach(typesRecipe::add);
        return typesRecipe;
    }
}
