package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @BeforeAll
    private static List<Category> createList() {
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
        }
        return expected;
    }

    @Test
    void testGetCategories() {
        List<Category> expected = createList();
        List<Category> obtained = categoryService.getCategories();
        assertArrayEquals(obtained.toArray(), expected.toArray());
    }

    @Test
    void getCategoryById() {

    }
}