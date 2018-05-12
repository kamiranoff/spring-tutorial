package com.nemeantalestudios.spring5webapp.bootstrap;

import com.nemeantalestudios.spring5webapp.models.Author;
import com.nemeantalestudios.spring5webapp.models.Book;
import com.nemeantalestudios.spring5webapp.models.Publisher;
import com.nemeantalestudios.spring5webapp.repositories.AuthorRepository;
import com.nemeantalestudios.spring5webapp.repositories.BookRepository;
import com.nemeantalestudios.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author kevin
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {
        this.generateIliad();
        this.generateMetamorphoses();
    }

    private void generateIliad() {
        Author homer = new Author("", "Homer");
        Publisher abeBooks = new Publisher("AbeBooks", "No address known");
        Book iliad = new Book("Iliad", "9781520017402", abeBooks);

        homer.getBooks().add(iliad);
        iliad.getAuthors().add(homer);

        publisherRepository.save(abeBooks);
        authorRepository.save(homer);
        bookRepository.save(iliad);
    }

    private void generateMetamorphoses() {
        Author ovid = new Author("", "Ovid");
        Publisher heightAD = new Publisher("8 AD", "America");
        Book metamorphoses = new Book("Metamorphoses", "9782070308712", heightAD);
        ovid.getBooks().add(metamorphoses);
        metamorphoses.getAuthors().add(ovid);

        publisherRepository.save(heightAD);
        authorRepository.save(ovid);
        bookRepository.save(metamorphoses);

    }
}
