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
    private String recipe;

    @Lob
    private String recipeNotes;


}
