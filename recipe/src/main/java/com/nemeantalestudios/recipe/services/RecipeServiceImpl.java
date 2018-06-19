package com.nemeantalestudios.recipe.services;

import com.google.common.collect.ImmutableSet;
import com.nemeantalestudios.recipe.commands.RecipeCommand;
import com.nemeantalestudios.recipe.converters.RecipeCommandToRecipe;
import com.nemeantalestudios.recipe.converters.RecipeToRecipeCommand;
import com.nemeantalestudios.recipe.models.Recipe;
import com.nemeantalestudios.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;


    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             RecipeCommandToRecipe recipeCommandToRecipe,
                             RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        return ImmutableSet.copyOf(recipeRepository.findAll());
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Could not find recipe by id");
        }

        return recipeOptional.get();
    }

    @Override
    public Recipe deleteById(Long id) {
        recipeRepository.deleteById(Long.valueOf(id));

        return null;
    }

    @Override
    @Transactional
    public RecipeCommand saveCommand(RecipeCommand recipeCommand) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);

        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }
}
