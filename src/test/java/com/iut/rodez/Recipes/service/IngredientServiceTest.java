package com.iut.rodez.Recipes.service;


import com.iut.rodez.Recipes.model.Category;
import com.iut.rodez.Recipes.model.Ingredient;
import com.iut.rodez.Recipes.repository.IngredientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IngredientServiceTest {
    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private IngredientRepository ingredientRepository;
    private String name;
    private String id;
    private String image;
    private String nameExpected;
    private String idExpected;
    private String imageExpected;
    private String nameCategory;
    private String idCategory;
    private String nameCategoryExpected;
    private String idCategoryExpected;
    private Category category;
    private Category categoryExpected;


    @Test
    void getIngredients() {

        List<String> ids_category = createListIdCategory();
        try {
            ingredientService.getIngredients(null, ids_category);
            assertFalse(false);
        } catch (ResponseStatusException name_null) {
            assertTrue(true);
        }

        try {
            ingredientService.getIngredients(null, null);
            assertFalse(false);
        } catch (ResponseStatusException args_null) {
            assertTrue(true);
        }

        try {
            ingredientService.getIngredients("tomate", null);
            assertFalse(false);
        } catch (ResponseStatusException ids_category_null) {
            assertTrue(true);
        }

        assertTrue(firstGetIngredientsTest());
        assertTrue(secondGetIngredientsTest());
        assertTrue(thirdGetIngredientsTest());
    }

    @Test
    void getIngredientById() {
        List<Ingredient> ingredientsTest = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredientsTest::add);
        ingredientsTest.stream().filter(i -> "kpfVMPPFyyr7H6P".equals(i.getId())
                        || "pFEJtgWTw1eJgfj".equals(i.getId())
                        || "kZT2WDH6wwYwMpj".equals(i.getId()))
                .collect(Collectors.toList());

        try {
            ingredientService.getIngredientById("idInvented");
        } catch (ResponseStatusException ingredientNotFound) {
        }

        for(int index = 0; index < ingredientsTest.size(); index++) {
            Optional<Ingredient> obtained = ingredientService.getIngredientById(ingredientsTest.get(index).getId());

            nameExpected = ingredientsTest.get(index).getName();
            idExpected = ingredientsTest.get(index).getId();
            categoryExpected = ingredientsTest.get(index).getCategory();
            idCategoryExpected = categoryExpected.getId();
            nameCategoryExpected = categoryExpected.getName();
            imageExpected = ingredientsTest.get(index).getImage();

            name = obtained.get().getName();
            id = obtained.get().getId();
            category = obtained.get().getCategory();
            idCategory = category.getId();
            nameCategory = category.getName();
            image = obtained.get().getImage();

            assertTrue(id.equals(idExpected));
            assertTrue(name.equals(nameExpected));
            assertTrue(idCategory.equals(idCategoryExpected));
            assertTrue(nameCategory.equals(nameCategoryExpected));
            assertTrue(image.equals(imageExpected));
        }
    }

    @Test
    void postIngredient() {
    }

    @Test
    void deleteIngredient() {
    }

    @Test
    void putIngredient() {
    }

    private List<String> createListIdCategory() {
        String[] ids = {
                "01","02","03","04",
                "05","06","07","08","09"
        };

        List<String> ids_category = new ArrayList<>();

        for (int index = 0; index < ids.length; index++) {
            ids_category.add(ids[index]);
        }
        return ids_category;
    }

    private boolean firstGetIngredientsTest() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(expectedIngredients::add);
        List<String> ids_category = createListIdCategory();

        boolean ok;

        /** First test with all ingredients obtained */
        List<Ingredient> obtained = ingredientService.getIngredients("", ids_category);
        ok = true;
        for (int index = 0; ok && index < expectedIngredients.size(); index++) {
             name = obtained.get(index).getName();
             id = obtained.get(index).getId();
             category = obtained.get(index).getCategory();
             nameCategory = category.getName();
             idCategory = category.getId();
             image = obtained.get(index).getImage();

             nameExpected = expectedIngredients.get(index).getName();
             idExpected = expectedIngredients.get(index).getId();
             categoryExpected = expectedIngredients.get(index).getCategory();
             nameCategoryExpected = categoryExpected.getName();
             idCategoryExpected = categoryExpected.getId();
             imageExpected = expectedIngredients.get(index).getImage();

             ok = name.equalsIgnoreCase(nameExpected);
             ok &= id.equalsIgnoreCase(idExpected);
             ok &= image.equalsIgnoreCase(imageExpected);
             ok &=idCategory.equalsIgnoreCase(idCategoryExpected);
             ok &= nameCategory.equalsIgnoreCase(nameCategoryExpected);
        }
        return ok;
    }

    private boolean secondGetIngredientsTest() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        List<Ingredient> expectedIngredientsTest2 = new ArrayList<>();
        ingredientRepository.findAll().forEach(expectedIngredients::add);
        List<String> ids_category = createListIdCategory();

        for (int index = 0; index < expectedIngredients.size(); index++) {
            if (expectedIngredients.get(index).getName().equalsIgnoreCase("Tomate")) {
                expectedIngredientsTest2.add(expectedIngredients.get(index));

            }
        }
        boolean ok;
        List<Ingredient> obtainedV2 = ingredientService.getIngredients("Tomate", ids_category);
        ok = true;
        for (int index = 0; ok && index < expectedIngredientsTest2.size(); index++) {
            name = obtainedV2.get(index).getName();
            id = obtainedV2.get(index).getId();
            category = obtainedV2.get(index).getCategory();
            nameCategory = category.getName();
            idCategory = category.getId();
            image = obtainedV2.get(index).getImage();

            nameExpected = expectedIngredientsTest2.get(index).getName();
            idExpected = expectedIngredientsTest2.get(index).getId();
            categoryExpected = expectedIngredientsTest2.get(index).getCategory();
            nameCategoryExpected = categoryExpected.getName();
            idCategoryExpected = categoryExpected.getId();
            imageExpected = expectedIngredientsTest2.get(index).getImage();

            ok = name.equalsIgnoreCase(nameExpected);
            ok &= id.equalsIgnoreCase(idExpected);
            ok &= image.equalsIgnoreCase(imageExpected);
            ok &= idCategory.equalsIgnoreCase(idCategoryExpected);
            ok &= nameCategory.equalsIgnoreCase(nameCategoryExpected);
        }
        return ok;
    }

    private boolean thirdGetIngredientsTest() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(expectedIngredients::add);
        List<Ingredient> expectedIngredientsTest3 = new ArrayList<>();
        List<String> ids_category = createListIdCategory();
        List<String> idTest = new ArrayList<>();
        idTest.add("02");
        boolean ok ;

        for (int index = 0; index < expectedIngredients.size(); index++) {
            if (expectedIngredients.get(index).getCategory().getId().equalsIgnoreCase("02")) {
                expectedIngredientsTest3.add(expectedIngredients.get(index));
            }
        }

        List<Ingredient> obtainedV3 = ingredientService.getIngredients("", idTest);
        ok = true;
        for (int index = 0; ok && index < expectedIngredientsTest3.size(); index++) {
            name = obtainedV3.get(index).getName();
            id = obtainedV3.get(index).getId();
            category = obtainedV3.get(index).getCategory();
            nameCategory = category.getName();
            idCategory = category.getId();
            image = obtainedV3.get(index).getImage();

            nameExpected = expectedIngredientsTest3.get(index).getName();
            idExpected = expectedIngredientsTest3.get(index).getId();
            categoryExpected = expectedIngredientsTest3.get(index).getCategory();
            nameCategoryExpected = categoryExpected.getName();
            idCategoryExpected = categoryExpected.getId();
            imageExpected = expectedIngredientsTest3.get(index).getImage();

            ok = name.equalsIgnoreCase(nameExpected);
            ok &= id.equalsIgnoreCase(idExpected);
            ok &= image.equalsIgnoreCase(imageExpected);
            ok &= idCategory.equalsIgnoreCase(idCategoryExpected);
            ok &= nameCategory.equalsIgnoreCase(nameCategoryExpected);
        }
        return ok;
    }
}