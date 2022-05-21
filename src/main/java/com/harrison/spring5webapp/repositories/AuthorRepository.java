package com.harrison.spring5webapp.repositories;

import com.harrison.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harrison Pan
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}