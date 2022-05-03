package com.iut.rodez.Recipes.controller;

import com.iut.rodez.Recipes.model.LinkRecipes;
import com.iut.rodez.Recipes.service.LinkRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class LinkRecipesController {

    @Autowired
    private LinkRecipesService linkRecipesService;

    @GetMapping("/links_recipes")
    public List<LinkRecipes> getLinksRecipes() {
        return linkRecipesService.getLinksRecipes();
    }
}
