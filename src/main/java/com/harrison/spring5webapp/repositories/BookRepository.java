package com.harrison.spring5webapp.repositories;

import com.harrison.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harrison Pan
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}