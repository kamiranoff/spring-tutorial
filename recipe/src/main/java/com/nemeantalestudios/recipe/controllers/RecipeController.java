package com.nemeantalestudios.recipe.controllers;

import com.nemeantalestudios.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Controller
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipes")
    public String renderRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "recipes";
    }
}



/**
 * @author kevin
 */

