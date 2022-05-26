package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Category;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void testGetCategories() {
        List<Category> expected = createList();
        List<Category> obtained = categoryService.getCategories();

        String nameTest ;
        String name;
        String idTest ;
        String id;

        for (int index = 0; index < obtained.size(); index++) {
            name = obtained.get(index).getName();
            id = obtained.get(index).getId();
            nameTest = expected.get(index).getName();
            idTest = expected.get(index).getId();

            assertTrue(name.equalsIgnoreCase(nameTest));
            assertTrue(id.equalsIgnoreCase(idTest));
        }
    }

    private List<Category> createList() {
        String[] names = {
                "Fruit","Légume","Féculent","Liquide",
                "Produits laitiers", "Produits animal", "Matiere grasse",
                "Produits sucrées", "Épices"
        };

        String[] ids = {
                "01","02","03","04","05",
                "06", "07", "08", "09"
        };

        List<Category> expected = new ArrayList<>();

        for (int index = 0; index < names.length; index++) {
            Category category = new Category();
            category.setName(names[index]);
            category.setId(ids[index]);
            expected.add(category);
        }
        return expected;
    }
}