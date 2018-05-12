package com.nemeantalestudios.spring5webapp.repositories;

import com.nemeantalestudios.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kevin
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
