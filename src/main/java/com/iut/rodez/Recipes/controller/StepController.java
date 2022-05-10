package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Step;
import com.iut.rodez.Recipes.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StepController {

    @Autowired
    private StepService stepService;

    @GetMapping("/steps")
    public List<Step> getSteps() {
        return stepService.getSteps();
    }

    @PostMapping("/steps")
    public void postStep(@RequestBody Step step) {
        stepService.postStep(step);
    }

    @DeleteMapping("/steps/{id}")
    public void deleteStep(@PathVariable String id) {
        stepService.deleteStep(id);
    }

    @PutMapping("/steps/{id}")
    public void putStep(@RequestBody Step step, @PathVariable String id) {
        stepService.putStep(step, id);
    }
}
