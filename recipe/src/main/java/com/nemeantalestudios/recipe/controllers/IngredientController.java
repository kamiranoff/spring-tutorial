package com.nemeantalestudios.recipe.controllers;

import com.nemeantalestudios.recipe.commands.RecipeCommand;
import com.nemeantalestudios.recipe.models.Recipe;
import com.nemeantalestudios.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kevin.amiranoff on 25/06/2018
 */

@Controller
public class IngredientController {


    private RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipes/{id}/ingredients"})
    public String renderRecipes(@PathVariable String id, Model model) {
        RecipeCommand recipe = recipeService.findCommandById(Long.valueOf(id));

        model.addAttribute("recipe", recipe);

        return "recipe/ingredients";
    }
}
