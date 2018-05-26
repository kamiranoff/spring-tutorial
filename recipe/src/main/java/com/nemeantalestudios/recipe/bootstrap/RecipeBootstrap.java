package com.nemeantalestudios.recipe.bootstrap;

import com.nemeantalestudios.recipe.models.*;
import com.nemeantalestudios.recipe.repositories.CategoryRepository;
import com.nemeantalestudios.recipe.repositories.RecipeRepository;
import com.nemeantalestudios.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author kevin.amiranoff on 26/05/2018
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private Category getCategoryOrThrowException(String description) {
        return categoryRepository.findByDescription(description)
                .orElseThrow(() -> new RuntimeException("Expected Category Not Found"));
    }

    private UnitOfMeasure getUnitOfMeasureOrThrowException(String description) {
        return unitOfMeasureRepository.findByDescription(description)
                .orElseThrow(() -> new RuntimeException("Expected UOM Not Found"));
    }


    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(1);

        UnitOfMeasure teaspoon = getUnitOfMeasureOrThrowException("Teaspoon");
        UnitOfMeasure tablespoon = getUnitOfMeasureOrThrowException("Tablespoon");
        UnitOfMeasure dash = getUnitOfMeasureOrThrowException("Dash");
        UnitOfMeasure each = getUnitOfMeasureOrThrowException("Each");

        Category mexican = getCategoryOrThrowException("Mexican");
        Category american = getCategoryOrThrowException("American");


        Set<Category> guacamoleCategories = new HashSet<>();
        guacamoleCategories.add(mexican);
        guacamoleCategories.add(american);


        Recipe guacamoleRecipe = new Recipe();

        guacamoleRecipe.setCategories(guacamoleCategories);
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        guacamoleRecipe.setNotes(new Notes(guacamoleRecipe, "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great."));


        Ingredient avocado = new Ingredient("ripe avocado", new BigDecimal(2.0), each, guacamoleRecipe);
        Ingredient kosherSalt = new Ingredient("Kohser salt", new BigDecimal(0.5), teaspoon, guacamoleRecipe);
        Ingredient freshLimeJuice = new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tablespoon, guacamoleRecipe);
        Ingredient redOnion = new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoon, guacamoleRecipe);
        Ingredient serranoChile = new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal("1.5"), each, guacamoleRecipe);
        Ingredient cilantro = new Ingredient(" cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoon, guacamoleRecipe);
        Ingredient blackPepper = new Ingredient("freshly grated black pepper", new BigDecimal(1), dash, guacamoleRecipe);
        Ingredient tomato = new Ingredient("tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), each, guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(avocado);
        guacamoleRecipe.getIngredients().add(kosherSalt);
        guacamoleRecipe.getIngredients().add(freshLimeJuice);
        guacamoleRecipe.getIngredients().add(redOnion);
        guacamoleRecipe.getIngredients().add(serranoChile);
        guacamoleRecipe.getIngredients().add(cilantro);
        guacamoleRecipe.getIngredients().add(blackPepper);
        guacamoleRecipe.getIngredients().add(tomato);

        recipes.add(guacamoleRecipe);
        return recipes;

    }
}
