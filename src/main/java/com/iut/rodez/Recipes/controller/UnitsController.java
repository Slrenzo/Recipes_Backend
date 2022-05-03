package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Units;
import com.iut.rodez.Recipes.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UnitsController {

    @Autowired
    private UnitsService unitsService;

    @GetMapping("/units")
    public List<Units> getUnits() {
        return unitsService.getUnits();
    }
}
