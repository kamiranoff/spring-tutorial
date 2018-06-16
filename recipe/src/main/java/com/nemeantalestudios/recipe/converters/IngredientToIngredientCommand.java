package com.nemeantalestudios.recipe.converters;

import com.nemeantalestudios.recipe.commands.IngredientCommand;
import com.nemeantalestudios.recipe.models.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author kevin.amiranoff on 16/06/2018
 */

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Override
    public IngredientCommand convert(Ingredient source) {

        IngredientCommand ingredientCommand = new IngredientCommand();

        ingredientCommand.setId(source.getId());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setAmount(source.getAmount());

        ingredientCommand.setUnitOfMeasureCommand(uomConverter.convert(source.getUnitOfMeasure()));

        return ingredientCommand;
    }
}
