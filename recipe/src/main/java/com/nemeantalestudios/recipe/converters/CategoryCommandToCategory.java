package com.nemeantalestudios.recipe.converters;

import com.nemeantalestudios.recipe.commands.CategoryCommand;
import com.nemeantalestudios.recipe.models.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author kevin.amiranoff on 04/06/2018
 */

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Override
    public Category convert(CategoryCommand categoryCommand) {

        final Category category = new Category();
        category.setId(categoryCommand.getId());
        category.setDescription(categoryCommand.getDescription());

        return category;
    }
}
