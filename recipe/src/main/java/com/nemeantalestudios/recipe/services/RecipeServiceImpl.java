package com.nemeantalestudios.recipe.services;

import com.google.common.collect.ImmutableSet;
import com.nemeantalestudios.recipe.models.Recipe;
import com.nemeantalestudios.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.Set;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

//    @Override
//    public Set<Recipe> getRecipes() {
//        Set<Recipe> recipeSet = new HashSet<>();
//        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
//        return recipeSet;
//    }


    // Using guava
    @Override
    public Set<Recipe> getRecipes() {
        return ImmutableSet.copyOf(recipeRepository.findAll());
    }
}
