package com.nemeantalestudios.recipe.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kevin.amiranoff on 27/05/2018
 */
public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4l;
        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}