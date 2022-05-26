package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.Step;
import com.iut.rodez.Recipes.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class StepController {

    @Autowired
    private StepService stepService;

    @GetMapping("/steps")
    public List<Step> getSteps() {
        return stepService.getSteps();
    }

    @GetMapping("/steps/{id}")
    public Optional<Step> getStepsById(@PathVariable String id) {
        return stepService.getStepsById(id);
    }

    @PostMapping("/steps")
    public ResponseEntity<HttpStatus> postStep(@RequestBody Step step) {
        return stepService.postStep(step);
    }

    @DeleteMapping("/steps/{id}")
    public ResponseEntity<HttpStatus> deleteStep(@PathVariable String id) {
        return stepService.deleteStep(id);
    }

    @PutMapping("/steps/{id}")
    public ResponseEntity<HttpStatus> putStep(@RequestBody Step step, @PathVariable String id) {
        return stepService.putStep(step, id);
    }
}
