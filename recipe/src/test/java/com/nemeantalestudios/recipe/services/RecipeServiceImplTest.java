package com.nemeantalestudios.recipe.services;

import com.nemeantalestudios.recipe.converters.RecipeCommandToRecipe;
import com.nemeantalestudios.recipe.converters.RecipeToRecipeCommand;
import com.nemeantalestudios.recipe.models.Recipe;
import com.nemeantalestudios.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author kevin.amiranoff on 27/05/2018
 */
public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    private RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }


    @Test
    public void getRecipesByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void getRecipesTest() throws Exception {

        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeData);

        Set<Recipe> recipeSet = recipeService.getRecipes();

        assertEquals(1, recipeSet.size());
        assertNotEquals(2, recipeSet.size());

        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteRecipeById() throws Exception {
        Long idToDelete = 1L;
        recipeService.deleteById(idToDelete);
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}