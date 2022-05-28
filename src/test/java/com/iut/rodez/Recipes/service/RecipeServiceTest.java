package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.Category;
import com.iut.rodez.Recipes.model.RecipeShortResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CategoryService categoryService;

    private String name;

    private String id;

    private String image;

    private double time;

    private String nameExpected;

    private String idExpected;

    private String imageExpected;

    private double timeExpected;

    @Test
    void getRecipes() {
        assertTrue(firstTestOfGetRecipe());
        assertTrue(secondTestOfGetRecipe());
        assertTrue(thirdTestOfGetRecipe());

    }

    @Test
    void getRecipeById() {
    }

    @Test
    void postRecipe() {
    }

    @Test
    void deleteRecipe() {
    }

    @Test
    void putRecipe() {
    }

    @Test
    void getRecipeForHomepage() {
    }


    private boolean firstTestOfGetRecipe() {
        boolean ok;

        List<String> testList = new ArrayList<>();
        List<RecipeShortResponse> expected = recipeTest();
        String[] nameTest = {"","Kebab"};

        ok = true;
        for (int index = 0; ok && index < nameTest.length; index ++) {
            List<RecipeShortResponse> obtained = recipeService.getRecipes(nameTest[index], idTest());

            for (int indexToTest = 0; ok && indexToTest < expected.size(); indexToTest++) {
                name = obtained.get(indexToTest).getName();
                id = obtained.get(indexToTest).getId();
                image = obtained.get(indexToTest).getImage();
                time = obtained.get(indexToTest).getTime();

                nameExpected = expected.get(indexToTest).getName();
                idExpected = expected.get(indexToTest).getId();
                imageExpected = expected.get(indexToTest).getImage();
                timeExpected = expected.get(indexToTest).getTime();

                ok = name.equals(nameExpected);
                ok &= id.equals(idExpected);
                // TODO SEE WITH ENZO
                //ok &= image.equals(imageExpected);
                ok &= time == timeExpected;
            }
            if (index == 0) {
                expected = recipeTest().stream()
                        .filter(r -> "kebab classique".equalsIgnoreCase(r.getName()))
                        .collect(Collectors.toList());
            }
        }
        return ok;
    }
    private boolean secondTestOfGetRecipe() {
        List<String> testList = new ArrayList<>();
        List<RecipeShortResponse> expected = new ArrayList<>();
        String[] nameTest = {"","Kebab"};
        boolean ok;

        ok = true;
        for (int index = 0; ok && index < nameTest.length; index++) {
            List<RecipeShortResponse> obtained = recipeService.getRecipes(nameTest[index], testList);

            for (int indexToTest = 0; ok && indexToTest < expected.size(); indexToTest ++) {
                name = obtained.get(indexToTest).getName();
                id = obtained.get(indexToTest).getId();
                image = obtained.get(indexToTest).getImage();
                time = obtained.get(indexToTest).getTime();

                nameExpected = expected.get(indexToTest).getName();
                idExpected = expected.get(indexToTest).getId();
                imageExpected = expected.get(indexToTest).getImage();
                timeExpected = expected.get(indexToTest).getTime();

                ok = name.equals(nameExpected);
                ok &= id.equals(idExpected);
                // TODO SEE WITH ENZO
                //ok &= image.equals(imageExpected);
                ok &= time == timeExpected;
            }
            if (index == 0) {
                expected = recipeTest().stream()
                        .filter(r -> "kebab classique".equalsIgnoreCase(r.getName()))
                        .collect(Collectors.toList());
            }
        }
        return ok;
    }
    private  boolean thirdTestOfGetRecipe() {
        List<String> testList = new ArrayList<>();
        List<RecipeShortResponse> expected = new ArrayList<>();
        String[] nameTest = {"","Kebab"};
        boolean ok;
        int count;

        ok = true;
        count = 0;
        testList.add("01");
        while (count < 2) {
            List<RecipeShortResponse> obtained = recipeService.getRecipes("", testList);
            for (int index = 0; ok && index < expected.size(); index++) {
                name = obtained.get(index).getName();
                id = obtained.get(index).getId();
                image = obtained.get(index).getImage();
                time = obtained.get(index).getTime();

                nameExpected = expected.get(index).getName();
                idExpected = expected.get(index).getId();
                imageExpected = expected.get(index).getImage();
                timeExpected = expected.get(index).getTime();

                ok = name.equals(nameExpected);
                ok &= id.equals(idExpected);
                // TODO SEE WITH ENZO
                //ok &= image.equals(imageExpected);
                ok &= time == timeExpected;
            }
            count++;
            testList.add("03");
            expected = recipeTest();
        }

        return true;
    }
    private List<String> idTest() {
        String[] ids = {
                "01","02","03","04","05",
                "06", "07", "08", "09"
        };

        List<String> expected = new ArrayList<>();

        for (int index = 0; index < ids.length; index++) {
            expected.add(ids[index]);
        }
        return expected;
    }

    private List<RecipeShortResponse> recipeTest() {
        String[] names = {
            "Kebab classique", "Aligot traditionnel"
        };
        String[] ids = {
                "mJBDCJpiAGa3ySm", "ssYFA13q32iGn99"
        };
        String[] images = {
                null, null
        };
        double[] times = {
                40.0, 60.0
        };

        List<RecipeShortResponse> expected = new ArrayList<>();

        for (int index = 0; index < ids.length; index++) {
            RecipeShortResponse recipe = new RecipeShortResponse();
            recipe.setId(ids[index]);
            recipe.setName(names[index]);
            recipe.setImage(images[index]);
            recipe.setTime(times[index]);
            expected.add(recipe);
        }
        return expected;
    }
}