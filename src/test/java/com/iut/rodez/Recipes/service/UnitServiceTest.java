package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Unit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UnitServiceTest {

    @Autowired
    private UnitService unitService;

    @Test
    void getUnits() {
        List<Unit> expected = createList();
        List<Unit> obtained = unitService.getUnits();

        String name;
        String id;
        String nameTest;
        String idTest;

        for (int index = 0; index < obtained.size(); index++) {
            name = obtained.get(index).getName();
            id = obtained.get(index).getId();
            nameTest = expected.get(index).getName();
            idTest = expected.get(index).getId();

            assertTrue(name.equals(nameTest));
            assertTrue(id.equalsIgnoreCase(idTest));
        }
    }

    private List<Unit> createList() {
        String[] names = {
                "l","ml","cl","C à s","C à c",
                "Carré","g","kg","Unités","Cube",
                "Gousses","Tranches","Pincée","Branche",
                "Verre","Noix","Filet","Brin","Feuilles"
        };

        String[] ids = {
                "01","02","03","04","05",
                "06","07", "08","09","10",
                "11","12","13","14","15",
                "16","17","18","19"
        };

        List<Unit> expected = new ArrayList<>();

        for (int index = 0; index < names.length; index++) {
            Unit unit = new Unit();
            unit.setName(names[index]);
            unit.setId(ids[index]);
            expected.add(unit);
        }

        return expected;
    }
}