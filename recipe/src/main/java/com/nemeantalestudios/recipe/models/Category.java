package com.nemeantalestudios.recipe.models;

import javax.persistence.*;
import java.util.Set;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;


    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    public Long getId() {
        return id;
    }
}
