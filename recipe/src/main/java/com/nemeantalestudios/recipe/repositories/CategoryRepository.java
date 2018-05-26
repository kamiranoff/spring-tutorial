package com.nemeantalestudios.recipe.repositories;

import com.nemeantalestudios.recipe.models.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kevin.amiranoff on 26/05/2018
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
