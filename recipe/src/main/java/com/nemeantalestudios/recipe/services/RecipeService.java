package com.nemeantalestudios.recipe.services;

import com.nemeantalestudios.recipe.commands.RecipeCommand;
import com.nemeantalestudios.recipe.models.Recipe;

import java.util.Set;

/**
 * @author kevin.amiranoff on 26/05/2018
 */
public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveCommand(RecipeCommand recipeCommand);

    RecipeCommand findCommandById(Long id);
}
