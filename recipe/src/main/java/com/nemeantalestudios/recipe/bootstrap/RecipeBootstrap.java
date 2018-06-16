package com.nemeantalestudios.recipe.bootstrap;

import com.nemeantalestudios.recipe.models.*;
import com.nemeantalestudios.recipe.repositories.CategoryRepository;
import com.nemeantalestudios.recipe.repositories.RecipeRepository;
import com.nemeantalestudios.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author kevin.amiranoff on 26/05/2018
 */
@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private Category getCategoryOrThrowException(String description) {
        return categoryRepository.findByDescription(description)
                .orElseThrow(() -> new RuntimeException("Expected Category Not Found"));
    }

    private UnitOfMeasure getUnitOfMeasureOrThrowException(String description) {
        return unitOfMeasureRepository.findByDescription(description)
                .orElseThrow(() -> new RuntimeException("Expected UOM Not Found: " + description ));
    }

    private Recipe makeGuaGuacamole() {

        Category mexican = getCategoryOrThrowException("Mexican");
        Category american = getCategoryOrThrowException("American");

        Set<Category> guacamoleCategories = new HashSet<>();
        guacamoleCategories.add(mexican);
        guacamoleCategories.add(american);

        UnitOfMeasure teaspoon = getUnitOfMeasureOrThrowException("Teaspoon");
        UnitOfMeasure tablespoon = getUnitOfMeasureOrThrowException("Tablespoon");
        UnitOfMeasure dash = getUnitOfMeasureOrThrowException("Dash");
        UnitOfMeasure each = getUnitOfMeasureOrThrowException("Each");

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
        guacamoleRecipe.addIngredient(avocado);
        guacamoleRecipe.addIngredient(kosherSalt);
        guacamoleRecipe.addIngredient(freshLimeJuice);
        guacamoleRecipe.addIngredient(redOnion);
        guacamoleRecipe.addIngredient(serranoChile);
        guacamoleRecipe.addIngredient(cilantro);
        guacamoleRecipe.addIngredient(blackPepper);
        guacamoleRecipe.addIngredient(tomato);

        return guacamoleRecipe;
    }

    private Recipe makeTacos() {
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);


        UnitOfMeasure teaspoon = getUnitOfMeasureOrThrowException("Teaspoon");
        UnitOfMeasure tablespoon = getUnitOfMeasureOrThrowException("Tablespoon");
        UnitOfMeasure cup = getUnitOfMeasureOrThrowException("Cup");
        UnitOfMeasure each = getUnitOfMeasureOrThrowException("Each");
        UnitOfMeasure pint = getUnitOfMeasureOrThrowException("Pint");


        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tablespoon));
        tacosRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoon));
        tacosRecipe.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaspoon));
        tacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoon));
        tacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), teaspoon));
        tacosRecipe.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), each));
        tacosRecipe.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tablespoon));
        tacosRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoon));
        tacosRecipe.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tablespoon));
        tacosRecipe.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tablespoon));
        tacosRecipe.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), each));
        tacosRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cup));
        tacosRecipe.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), each));
        tacosRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), each));
        tacosRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pint));
        tacosRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), each));
        tacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), each));
        tacosRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cup));
        tacosRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), each));

        Category mexican = getCategoryOrThrowException("Mexican");
        Category american = getCategoryOrThrowException("American");

        tacosRecipe.getCategories().add(mexican);
        tacosRecipe.getCategories().add(american);

        tacosRecipe.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacosRecipe.setServings(4);
        tacosRecipe.setSource("Simply Recipes");

        return tacosRecipe;
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(1);

        Recipe guacamoleRecipe = makeGuaGuacamole();
        Recipe tacosRecioe = makeTacos();

        recipes.add(guacamoleRecipe);
        recipes.add(tacosRecioe);

        log.debug("Returning Recipes", recipes);

        return recipes;

    }
}
