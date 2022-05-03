package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Step;
import com.iut.rodez.Recipes.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StepController {

    @Autowired
    private StepService stepService;

    @GetMapping("/steps")
    public List<Step> getSteps() {
        return stepService.getSteps();
    }
}
