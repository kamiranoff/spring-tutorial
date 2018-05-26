package com.nemeantalestudios.recipe.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public UnitOfMeasure(String description) {
        this.description = description;
    }

    public UnitOfMeasure() {
    }
}
