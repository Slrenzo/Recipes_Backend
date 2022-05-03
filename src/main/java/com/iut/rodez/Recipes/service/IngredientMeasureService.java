package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.IngredientMeasure;
import com.iut.rodez.Recipes.repository.IngredientMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientMeasureService {

    @Autowired
    private IngredientMeasureRepository ingredientMeasureRepository;

    public List<IngredientMeasure> getIngredientsMeasures() {
        List<IngredientMeasure> ingredientsMeasures = new ArrayList<>();
        ingredientMeasureRepository.findAll().forEach(link -> {
            ingredientsMeasures.add(link);
        });
        return ingredientsMeasures;
    }
}
