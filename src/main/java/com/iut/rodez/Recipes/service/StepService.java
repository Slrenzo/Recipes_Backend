package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Step;
import com.iut.rodez.Recipes.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StepService {

    @Autowired
    private StepRepository stepRepository;

    public ResponseEntity<List<Step>> getSteps() {
        List<Step> steps = new ArrayList<>();
        stepRepository.findAll().forEach(steps::add);
        return new ResponseEntity<>(steps, HttpStatus.OK);
    }

    public ResponseEntity<Optional<Step>> getStepsById(String id) {
        if (!stepRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stepRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<Step> postStep(Step step) {
        if (step.getStep_order() <= 0 || step.getDescr().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        stepRepository.save(step);
        return new ResponseEntity<>(step, HttpStatus.CREATED);
    }

    public ResponseEntity<HttpStatus> deleteStep(String id) {
        if (!stepRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        stepRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Step> putStep(Step step, String id) {
        if (!stepRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (step.getStep_order() <= 0 || step.getDescr().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        stepRepository.save(step);
        return new ResponseEntity<>(step, HttpStatus.OK);
    }
}
