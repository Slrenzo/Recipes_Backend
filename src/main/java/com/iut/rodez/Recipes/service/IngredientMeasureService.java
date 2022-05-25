package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.IngredientMeasure;
import com.iut.rodez.Recipes.model.IngredientMeasureRequest;
import com.iut.rodez.Recipes.repository.IngredientMeasureRepository;
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
public class IngredientMeasureService {

    @Autowired
    private IngredientMeasureRepository ingredientMeasureRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private UnitRepository unitRepository;

    public List<IngredientMeasure> getIngredientsMeasures() {
        List<IngredientMeasure> ingredientsMeasures = new ArrayList<>();
        ingredientMeasureRepository.findAll().forEach(ingredientsMeasures::add);
        return ingredientsMeasures;
    }

    public Optional<IngredientMeasure> getIngredientMeasureById(String id) {
        if (!ingredientMeasureRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ingredientMeasureRepository.findById(id);
    }

    public ResponseEntity<HttpStatus> postIngredientMeasure(IngredientMeasureRequest ingredientMeasureRequest) {
        if (!ingredientRepository.existsById(ingredientMeasureRequest.getIngredientId())
            || ingredientMeasureRequest.getQuantity() <= 0.0
            || !unitRepository.existsById(ingredientMeasureRequest.getUnitId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        IngredientMeasure ingredientMeasure = new IngredientMeasure();
        ingredientMeasure.setIngredient(ingredientRepository.findById(ingredientMeasureRequest.getIngredientId()).get());
        ingredientMeasure.setQuantity(ingredientMeasureRequest.getQuantity());
        ingredientMeasure.setUnit(unitRepository.findById(ingredientMeasureRequest.getUnitId()).get());
        ingredientMeasureRepository.save(ingredientMeasure);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<HttpStatus> deleteIngredientMeasure(String id) {
        if (!ingredientMeasureRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        ingredientMeasureRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> putIngredientMeasure(IngredientMeasureRequest ingredientMeasureRequest, String id) {
        if (!ingredientMeasureRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        IngredientMeasure ingredientMeasure = ingredientMeasureRepository.findById(id).get();
        if (!ingredientRepository.existsById(ingredientMeasureRequest.getIngredientId())
                || ingredientMeasureRequest.getQuantity() <= 0.0
                || !unitRepository.existsById(ingredientMeasureRequest.getUnitId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        ingredientMeasure.setIngredient(ingredientRepository.findById(ingredientMeasureRequest.getIngredientId()).get());
        ingredientMeasure.setQuantity(ingredientMeasureRequest.getQuantity());
        ingredientMeasure.setUnit(unitRepository.findById(ingredientMeasureRequest.getUnitId()).get());
        ingredientMeasureRepository.save(ingredientMeasure);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
