package com.nemeantalestudios.recipe.converters;

import com.nemeantalestudios.recipe.commands.IngredientCommand;
import com.nemeantalestudios.recipe.models.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author kevin.amiranoff on 04/06/2018
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {


        final Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientCommand.getId());
        ingredient.setDescription(ingredientCommand.getDescription());
        ingredient.setAmount(ingredientCommand.getAmount());

        return ingredient;
    }
}
