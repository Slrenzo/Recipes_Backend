package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Units;
import com.iut.rodez.Recipes.repository.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitsService {

    @Autowired
    private UnitsRepository unitsRepository;

    public List<Units> getUnits() {
        List<Units> units = new ArrayList<>();
        unitsRepository.findAll().forEach(unit -> {
            units.add(unit);
        });
        return units;
    }
}
