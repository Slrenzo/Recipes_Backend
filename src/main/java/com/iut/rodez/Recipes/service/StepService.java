package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Step;
import com.iut.rodez.Recipes.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StepService {

    @Autowired
    private StepRepository stepRepository;

    public List<Step> getSteps() {
        List<Step> steps = new ArrayList<>();
        stepRepository.findAll().forEach(step -> {
            steps.add(step);
        });
        return steps;
    }

    public void postStep(Step step) {
        stepRepository.save(step);
    }

    public void deleteStep(String id) {
        stepRepository.deleteById(id);
    }

    public void putStep(Step step, String id) {
        stepRepository.save(step);
    }
}
