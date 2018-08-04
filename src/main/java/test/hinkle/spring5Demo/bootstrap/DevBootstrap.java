package test.hinkle.spring5Demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import test.hinkle.spring5Demo.model.Author;
import test.hinkle.spring5Demo.model.Book;
import test.hinkle.spring5Demo.model.Publisher;
import test.hinkle.spring5Demo.repositories.AuthorRepository;
import test.hinkle.spring5Demo.repositories.BookRepository;
import test.hinkle.spring5Demo.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private BookRepository bookRepository;
  private AuthorRepository authorRepository;
  private PublisherRepository publisherRepository;

  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initData();
  }

  private void initData(){


    //Cat
    Author cat = new Author("Cat","Artis");
    Book catBook = new Book("Kitty Cat get married", "1234");
    Publisher catPub = new Publisher("Penguins", "123 omg");
    catBook.setPublisher(catPub);
    cat.getBooks().add(catBook);
    catBook.getAuthors().add(cat);


    //Corey
    Author corey = new Author("Corey", "Hinkle");
    Book corBook = new Book("Meeting my love", "4321");
    Publisher corPub = new Publisher("Lions", "456 wtf");
    corBook.setPublisher(corPub);
    corey.getBooks().add(corBook);
    corBook.getAuthors().add(corey);

    publisherRepository.save(catPub);
    publisherRepository.save(corPub);

    authorRepository.save(cat);
    authorRepository.save(corey);

    bookRepository.save(catBook);
    bookRepository.save(corBook);


  }

}
