package com.nemeantalestudios.recipe.services;

import com.nemeantalestudios.recipe.models.Recipe;

import java.util.Set;

/**
 * @author kevin.amiranoff on 26/05/2018
 */
public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
