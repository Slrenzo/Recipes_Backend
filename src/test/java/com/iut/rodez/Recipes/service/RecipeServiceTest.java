package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.*;
import com.iut.rodez.Recipes.repository.IngredientRepository;
import com.iut.rodez.Recipes.repository.IngredientsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.aspectj.apache.bcel.Constants.types;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private IngredientsService ingredientsService;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Autowired
    private StepService stepService;

    private String name;

    private String id;

    private String image;

    private double time;

    private int people;

    private Type type;

    private String nameType;

    private String idType;

    private List<IngredientsResponse> ingredients;

    private List<Step> steps;

    private String nameExpected;

    private String idExpected;

    private String imageExpected;

    private double timeExpected;

    private int peopleExpected;

    private Type typeExpected;

    private String nameTypeExpected;

    private String idTypeExpected;

    private List<IngredientsResponse> ingredientsExpected;

    private List<Step> stepsExpected;

    @Test
    void getRecipes() {
        assertTrue(firstTestOfGetRecipe());
        assertTrue(secondTestOfGetRecipe());
        assertTrue(thirdTestOfGetRecipe());

    }

    @Test
    void getRecipeById() {
        List<RecipeResponse> expected = recipeTest();
        String[] ids = {"mJBDCJpiAGa3ySm", "ssYFA13q32iGn99"};

        assertThrows(ResponseStatusException.class, () -> recipeService.getRecipeById("idNotInBase"));
        RecipeResponse test = recipeService.getRecipeById("ssYFA13q32iGn99");
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
        List<RecipeShortResponse> expected = recipeShortTest();
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
                expected = recipeShortTest().stream()
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
                expected = recipeShortTest().stream()
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
            expected = recipeShortTest();
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

    private List<RecipeShortResponse> recipeShortTest() {
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

    private List<RecipeResponse> recipeTest() {

        List<IngredientsResponse> ingredientsForFirst = new ArrayList<>();
        List<IngredientsResponse> ingredientsForSecond = new ArrayList<>();
        List<Category> categories = categoryService.getCategories();
        List<String> categoriesToAdd = new ArrayList<>();
        categories.forEach(category -> categoriesToAdd.add(category.getId()));

        String[] names = {
                "Kebab classique", "Aligot traditionnel"
        };
        String[] ids = {
                "mJBDCJpiAGa3ySm", "ssYFA13q32iGn99"
        };
        String[] images = {
                null, null
        };
        int[] times = {
                40, 60
        };
        int[] people = {
                1, 2
        };
        double[] quantities = {
                4.0,1.0,1.0,1.0,1.0,
                500.0,25.0,1.0,4.0,
                20.0,1.0,1.0
        };
        String[] units = {
                "09","09","04","09","09",
                "07","03","09","11","07",
                "08","09"
        };

        List<Type> types = typeService.getTypesRecipe().stream()
                                        .filter(t -> t.getId().equals("03")).collect(Collectors.toList());

        List<IngredientsResponse> ingredients = ingredientsService.getIngredients();
        ingredientsForFirst = ingredients.stream().filter(i -> i.getId().equals("bpSpN2zckHlUoK9")
                                                 || i.getId().equals("cJVmYtVd377o2It")
                                                 || i.getId().equals("dHfgb7Wv24193Wj")
                                                 || i.getId().equals("vmjkwmYa7cOmanD")
                                                 || i.getId().equals("XyGTs486DsnDe0x"))
                                                  .collect(Collectors.toList());

        ingredientsForSecond = ingredients.stream().filter(i -> i.getId().equals("akQGcBQ1wBymznr")
                                                || i.getId().equals("LdXCTllmPGR24vM")
                                                || i.getId().equals("lF9SoSZQr2xAYlf")
                                                || i.getId().equals("oGzOz56OAN6JgWN")
                                                || i.getId().equals("rmFYs3WDiwT1jfz")
                                                || i.getId().equals("SrSyItBNdYuC84b")
                                                || i.getId().equals("YEGpksbMGWlIz1Y"))
                                                 .collect(Collectors.toList());

        for (int indexForIng = 0; indexForIng < ingredientsForFirst.size(); indexForIng++) {
            ingredientsForFirst.get(indexForIng).setQuantity(quantities[indexForIng]);
            ingredientsForFirst.get(indexForIng).setUnit(units[indexForIng]);

        }
        for (int indexForIng2 = 5; indexForIng2 < ingredientsForSecond.size();indexForIng2++) {
            ingredientsForSecond.get(indexForIng2).setQuantity(quantities[indexForIng2]);
            ingredientsForSecond.get(indexForIng2).setUnit(units[indexForIng2]);
        }

        List<Step> steps = new ArrayList<>(stepService.getSteps());
        List<Step> stepForFirst = steps.stream().filter(step -> step.getId().equals("CkCMbSjAVbuXlCb")
                                                             || step.getId().equals("jIyrYXrmwjdsWKz")
                                                             || step.getId().equals("ru4JZaVe00PUnCy")
                                                             || step.getId().equals("ZQK2h00ECqOgSw7"))
                                                .collect(Collectors.toList());
        List<Step> stepForSecond = steps.stream().filter(step -> step.getId().equals("1FPbAMUrhi8YNwK")
                                                             || step.getId().equals("LmmfwO3bkzW7Ked")
                                                             || step.getId().equals("pjf5mL62m9bruTl")
                                                             || step.getId().equals("sbH55jNRSlsxox3"))
                                                .collect(Collectors.toList());


        List<RecipeResponse> expected = new ArrayList<>();
        for (int index = 0; index < names.length; index++) {
            RecipeResponse recipe = new RecipeResponse();
            recipe.setId(ids[index]);
            recipe.setName(names[index]);
            recipe.setImage(images[index]);
            if (index == 0) {
                recipe.setSteps(stepForFirst);
                recipe.setIngredients(ingredientsForFirst);
            }else {
                recipe.setSteps(stepForSecond);
                recipe.setIngredients(ingredientsForSecond);
            }
            recipe.setType(types.get(0));
            recipe.setPeople(people[index]);
            recipe.setTime(times[index]);
            expected.add(recipe);
        }

        return expected;
    }
}