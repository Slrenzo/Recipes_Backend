package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Unit;
import com.iut.rodez.Recipes.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping("/units")
    public List<Unit> getUnits() {
        return unitService.getUnits();
    }
}
