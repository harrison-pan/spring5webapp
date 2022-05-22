package com.harrison.spring5webapp.bootstrap;

import com.harrison.spring5webapp.domain.Author;
import com.harrison.spring5webapp.domain.Book;
import com.harrison.spring5webapp.domain.Publisher;
import com.harrison.spring5webapp.repositories.AuthorRepository;
import com.harrison.spring5webapp.repositories.BookRepository;
import com.harrison.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Harrison Pan
 */
@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Loading data...");
    System.out.println("Started in Bootstrap");

    Publisher publisher = new Publisher();
    publisher.setName("SFG Publishing");
    publisher.setCity("St Petersburg");
    publisher.setState("FL");

    publisherRepository.save(publisher);

    System.out.println("Publisher Count: " + publisherRepository.count());

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    ddd.setPublisher(publisher);
    publisher.getBooks().add(ddd);

    authorRepository.save(eric);
    bookRepository.save(ddd);
    publisherRepository.save(publisher);

    Author rod = new Author("Rod", "Johnson");
    Book noEjb = new Book("J2EE Development without EJB", "456456");
    rod.getBooks().add(noEjb);
    noEjb.getAuthors().add(rod);

    noEjb.setPublisher(publisher);
    publisher.getBooks().add(noEjb);

    authorRepository.save(rod);
    bookRepository.save(noEjb);
    publisherRepository.save(publisher);

    System.out.println("Number of books: " + bookRepository.count());
    System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
  }

}
