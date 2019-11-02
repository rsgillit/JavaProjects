package com.gill.spring5webapp.bootstrap;

import com.gill.spring5webapp.model.Author;
import com.gill.spring5webapp.model.Book;
import com.gill.spring5webapp.model.Publisher;
import com.gill.spring5webapp.repositories.AuthorRepository;
import com.gill.spring5webapp.repositories.BookRepository;
import com.gill.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        Author eric = new Author("Eric", "Evans");
        Publisher pub = new Publisher("Harper Collins", "123 main st Murphy");
        Book ddd = new Book("Domain Driven Design", "1234", pub);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(pub);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("rod","Johnson");
        Publisher pub1 = new Publisher("Worx", "456 main st Murphy");
        Book noEJB = new Book("J2EE development without EJB", "2345", pub1);
        rod.getBooks().add(noEJB);

        publisherRepository.save(pub1);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }


}
