package com.nemeantalestudios.spring5webapp.repositories;

import com.nemeantalestudios.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kevin
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
