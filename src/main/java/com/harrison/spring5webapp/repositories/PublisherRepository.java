package com.harrison.spring5webapp.repositories;

import com.harrison.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harrison Pan
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}