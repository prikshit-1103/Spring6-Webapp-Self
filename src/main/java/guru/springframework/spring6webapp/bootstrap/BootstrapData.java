package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository; // always make the objects of repositories to be final
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric= new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd= new Book();
        ddd.setTitle("Domain Driven Design Pattern");
        ddd.setIsbn("1234561");

        Author ericSaved= authorRepository.save(eric);
        Book dddSaved= bookRepository.save(ddd);

        Author rod= new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Jhonson");

        Book noEJB= new Book();
        ddd.setTitle("J2EE Development without EJB");
        ddd.setIsbn("5464890");

        Publisher publisher1= new Publisher();
        publisher1.setPublisherName("Jonathon Keen");
        publisher1.setAddress(" House No. 2314 ,Street 1 ");
        publisher1.setCity("London");
        publisher1.setState("London");
        publisher1.setZip("5001010");


        Publisher publisher1Saved= publisherRepository.save(publisher1);
        Author rodSaved= authorRepository.save(rod);
        Book noEJBSaved= bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved); // adding to the hashset of books for eric.
        rodSaved.getBooks().add(noEJBSaved);

        /*save the new book association in the repository*/
        authorRepository.save(ericSaved);
        authorRepository.save(rod);

        System.out.println("Inside BootStrap");
        System.out.println("Count of Authors: " + authorRepository.count());
        System.out.println("Count of Books: " + bookRepository.count());
        System.out.println("Count of Publishers: " + publisherRepository.count());
    }
}
