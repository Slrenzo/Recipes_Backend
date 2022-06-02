package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Unit;
import com.iut.rodez.Recipes.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public ResponseEntity<List<Unit>> getUnits() {
        List<Unit> units = new ArrayList<>();
        unitRepository.findAll().forEach(units::add);
        return new ResponseEntity<>(units, HttpStatus.OK);
    }
}
