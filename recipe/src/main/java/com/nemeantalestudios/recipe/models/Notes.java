package com.nemeantalestudios.recipe.models;

import javax.persistence.*;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    public Notes() {
    }

    public Notes(Recipe recipe, String recipeNotes) {
        this.recipe = recipe;
        this.recipeNotes = recipeNotes;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
