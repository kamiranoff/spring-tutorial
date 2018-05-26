package com.nemeantalestudios.recipe.models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeseure;

    @ManyToOne
    private Recipe recipe;

}
