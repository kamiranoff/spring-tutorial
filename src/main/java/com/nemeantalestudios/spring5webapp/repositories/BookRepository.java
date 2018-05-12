package com.nemeantalestudios.spring5webapp.repositories;

import com.nemeantalestudios.spring5webapp.models.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kevin
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
