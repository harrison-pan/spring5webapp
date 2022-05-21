package com.harrison.spring5webapp.bootstrap;

import com.harrison.spring5webapp.domain.Author;
import com.harrison.spring5webapp.domain.Book;
import com.harrison.spring5webapp.repositories.AuthorRepository;
import com.harrison.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Harrison Pan
 */
@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book noEjb = new Book("J2EE Development without EJB", "456456");
    rod.getBooks().add(noEjb);
    noEjb.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEjb);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of books: " + bookRepository.count());
  }

}
