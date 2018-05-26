package com.nemeantalestudios.recipe.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Data
@Entity
@EqualsAndHashCode(exclude="recipes")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    private Set<Recipe> recipes;

}
