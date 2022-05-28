package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Type;
import com.iut.rodez.Recipes.model.Unit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TypeServiceTest {

    @Autowired
    private TypeService typeService;

    @Test
    void getTypesRecipe() {
        List<Type> expected = createList();
        List<Type> obtained = typeService.getTypesRecipe();

        String name;
        String id;
        String nameTest;
        String idTest;

        for (int index = 0; index < expected.size(); index++) {
            name = obtained.get(index).getName();
            id = obtained.get(index).getId();
            nameTest = expected.get(index).getName();
            idTest = expected.get(index).getId();

            assertTrue(name.equals(nameTest));
            assertTrue(id.equalsIgnoreCase(idTest));
        }
    }

    private List<Type> createList() {
        String[] names = {
                "Apéritifs","Entrées","Plats",
                "Desserts","Boissons/Cocktails",
                "Petit-déj/Brunch","Hors-doeuvre/Bouchees",
                "Sauces/Vinaigrettes","Soupes/Potages",
                "Sandwichs","Collations"

        };

        String[] ids = {
                "01","02","03",
                "04","05", "06",
                "07", "08","09",
                "10", "11"
        };

        List<Type> expected = new ArrayList<>();

        for (int index = 0; index < names.length; index++) {
            Type type = new Type();
            type.setName(names[index]);
            type.setId(ids[index]);
            expected.add(type);
        }

        return expected;
    }
}