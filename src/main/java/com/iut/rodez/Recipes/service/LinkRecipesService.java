package com.iut.rodez.Recipes.service;

import com.iut.rodez.Recipes.model.LinkRecipes;
import com.iut.rodez.Recipes.repository.LinkRecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkRecipesService {

    @Autowired
    private LinkRecipesRepository linkRecipesRepository;

    public List<LinkRecipes> getLinksRecipes() {
        List<LinkRecipes> linksRecipes = new ArrayList<>();
        linkRecipesRepository.findAll().forEach(link -> {
            linksRecipes.add(link);
        });
        return linksRecipes;
    }
}
