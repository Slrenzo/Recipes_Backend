package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Ingredients;
import com.iut.rodez.Recipes.model.IngredientsRequest;
import com.iut.rodez.Recipes.repository.IngredientsRepository;
import com.iut.rodez.Recipes.repository.IngredientRepository;
import com.iut.rodez.Recipes.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientsService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private UnitRepository unitRepository;

    public List<Ingredients> getIngredients() {
        List<Ingredients> ingredients = new ArrayList<>();
        ingredientsRepository.findAll().forEach(ingredients::add);
        return ingredients;
    }

    public Optional<Ingredients> getIngredientsById(String id) {
        if (!ingredientsRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ingredientsRepository.findById(id);
    }

    public ResponseEntity<HttpStatus> postIngredients(IngredientsRequest ingredientsRequest) {
        if (!ingredientRepository.existsById(ingredientsRequest.getIngredientId())
            || ingredientsRequest.getQuantity() <= 0.0
            || !unitRepository.existsById(ingredientsRequest.getUnitId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Ingredients ingredientMeasure = new Ingredients();
        ingredientMeasure.setIngredient(ingredientRepository.findById(ingredientsRequest.getIngredientId()).get());
        ingredientMeasure.setQuantity(ingredientsRequest.getQuantity());
        ingredientMeasure.setUnit(unitRepository.findById(ingredientsRequest.getUnitId()).get());
        ingredientsRepository.save(ingredientMeasure);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<HttpStatus> deleteIngredients(String id) {
        if (!ingredientsRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        ingredientsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> putIngredients(IngredientsRequest ingredientsRequest, String id) {
        if (!ingredientsRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Ingredients ingredientMeasure = ingredientsRepository.findById(id).get();
        if (!ingredientRepository.existsById(ingredientsRequest.getIngredientId())
                || ingredientsRequest.getQuantity() <= 0.0
                || !unitRepository.existsById(ingredientsRequest.getUnitId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        ingredientMeasure.setIngredient(ingredientRepository.findById(ingredientsRequest.getIngredientId()).get());
        ingredientMeasure.setQuantity(ingredientsRequest.getQuantity());
        ingredientMeasure.setUnit(unitRepository.findById(ingredientsRequest.getUnitId()).get());
        ingredientsRepository.save(ingredientMeasure);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
