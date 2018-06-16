package com.nemeantalestudios.recipe.converters;

import com.nemeantalestudios.recipe.commands.RecipeCommand;
import com.nemeantalestudios.recipe.models.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author kevin.amiranoff on 16/06/2018
 */

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {


    private CategoryToCategoryCommand categoryToCategoryCommand;
    private NotesToNotesCommand notesToNotesCommand;
    private IngredientToIngredientCommand ingredientToIngredientCommand;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryToCategoryCommand,
                                 NotesToNotesCommand notesToNotesCommand,
                                 IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.categoryToCategoryCommand = categoryToCategoryCommand;
        this.notesToNotesCommand = notesToNotesCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Nullable
    @Synchronized
    @Override
    public RecipeCommand convert(Recipe recipe) {
        RecipeCommand recipeCommand = new RecipeCommand();

        recipeCommand.setId(recipe.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setNotes(notesToNotesCommand.convert(recipe.getNotes()));

        if (recipe.getCategories() != null && recipe.getCategories().size() > 0) {
            recipe.getCategories()
                    .forEach(category -> recipeCommand.getCategories().add(categoryToCategoryCommand.convert(category)));

        }

        if (recipe.getIngredients() != null && recipe.getIngredients().size() > 0) {
            recipe.getIngredients()
                    .forEach(ingredient -> recipeCommand.getIngredients().add(ingredientToIngredientCommand.convert(ingredient)));
        }

        return recipeCommand;
    }
}
