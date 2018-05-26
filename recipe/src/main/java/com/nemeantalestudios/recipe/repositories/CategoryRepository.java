package com.nemeantalestudios.recipe.repositories;

import com.nemeantalestudios.recipe.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author kevin.amiranoff on 26/05/2018
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
