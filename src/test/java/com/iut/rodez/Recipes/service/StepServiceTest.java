package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Ingredient;
import com.iut.rodez.Recipes.model.Step;
import com.iut.rodez.Recipes.model.Type;
import com.iut.rodez.Recipes.repository.StepRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StepServiceTest {

    @Autowired
    private StepService stepService;

    @Autowired
    private StepRepository stepRepository;

    private String id;
    private String idTest;
    private String desc;
    private String descTest;
    private int rank;
    private int rankTest;

    @Test
    void getSteps() {
        List<Step> expected = createList();
        List<Step> obtained = stepService.getSteps();

        for (int index = 0; index < obtained.size(); index++) {
            id = obtained.get(index).getId();
            idTest = expected.get(index).getId();
            desc = obtained.get(index).getDescr();
            descTest = expected.get(index).getDescr();
            rank = obtained.get(index).getStep_order();
            rankTest = expected.get(index).getStep_order();

            assertTrue(id.equalsIgnoreCase(idTest));
            assertTrue(desc.equals(descTest));
            assertEquals(rank, rankTest);
        }

    }

    @Test
    void getStepsById() {
        List<Step> stepTest = new ArrayList<>();
        stepRepository.findAll().forEach(stepTest::add);
        stepTest.stream().filter(i -> "ru4JZaVe00PUnCy".equals(i.getId())
                                || "1FPbAMUrhi8YNwK".equals(i.getId())
                                || "ZQK2h00ECqOgSw7".equals(i.getId()))
                         .collect(Collectors.toList());
        /** NOT_FOUND */
        assertThrows(ResponseStatusException.class, () -> stepService.getStepsById("idNotFoundInDataBase"));

        for(int index = 0; index < stepTest.size(); index++) {
            Optional<Step> obtained = stepService.getStepsById(stepTest.get(index).getId());

            id = obtained.get().getId();
            desc = obtained.get().getDescr();
            rank = obtained.get().getStep_order();

            idTest = stepTest.get(index).getId();
            descTest = stepTest.get(index).getDescr();
            rankTest = stepTest.get(index).getStep_order();

            assertTrue(id.equals(idTest));
            assertTrue(desc.equals(descTest));
            assertEquals(rank, rankTest);
        }
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