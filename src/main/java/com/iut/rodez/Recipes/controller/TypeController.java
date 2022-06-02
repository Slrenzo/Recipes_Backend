package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Type;
import com.iut.rodez.Recipes.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public ResponseEntity<List<Type>> getTypesRecipe() {
        return typeService.getTypesRecipe();
    }
}
