package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Step;
import com.iut.rodez.Recipes.model.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StepServiceTest {

    @Autowired
    private StepService stepService;

    @Test
    void getSteps() {
        List<Step> expected = createList();
        List<Step> obtained = stepService.getSteps();

        String id;
        String idTest;
        String desc;
        String descTest;
        int rank;
        int rankTest;

        for (int index = 0; index < obtained.size(); index++) {
            id = obtained.get(index).getId();
            idTest = expected.get(index).getId();
            desc = obtained.get(index).getDescr();
            descTest = expected.get(index).getDescr();
            rank = obtained.get(index).getStep_order();
            rankTest = expected.get(index).getStep_order();

            assertTrue(id.equalsIgnoreCase(idTest));
            assertTrue(desc.equals(descTest));
            assertTrue(rank == rankTest);
        }

    }

    @Test
    void getStepsById() {
    }

    @Test
    void postStep() {
    }

    @Test
    void deleteStep() {
    }

    @Test
    void putStep() {
    }

    private List<Step> createList() {
        String[] descr = {
                "Melanger","Casser",
                "Applatir","Ajouter",
                "Remuer","Frire",
                "Verser","Remuer"
        };

        int[] ranks = {
                4,2,4,3,
                1,3,2,1
        };

        String[] ids = {
                "1FPbAMUrhi8YNwK","CkCMbSjAVbuXlCb",
                "jIyrYXrmwjdsWKz","LmmfwO3bkzW7Ked",
                "pjf5mL62m9bruTl", "ru4JZaVe00PUnCy",
                "sbH55jNRSlsxox3","ZQK2h00ECqOgSw7"

        };

        List<Step> expected = new ArrayList<>();

        for (int index = 0; index < ids.length; index++) {
            Step step = new Step();
            step.setStep_order(ranks[index]);
            step.setDescr(descr[index]);
            step.setId(ids[index]);
            expected.add(step);
        }

        return expected;
    }
}