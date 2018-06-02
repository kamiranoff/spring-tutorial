package com.nemeantalestudios.recipe.services;

import com.google.common.collect.ImmutableSet;
import com.nemeantalestudios.recipe.models.Recipe;
import com.nemeantalestudios.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Getting Recipes");
        return ImmutableSet.copyOf(recipeRepository.findAll());
    }

    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if(!recipeOptional.isPresent()) {
            throw new RuntimeException("Could not find recipe by id");
        }

        return recipeOptional.get();
    }
}
