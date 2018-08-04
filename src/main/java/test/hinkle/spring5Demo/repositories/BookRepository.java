package test.hinkle.spring5Demo.repositories;

import org.springframework.data.repository.CrudRepository;
import test.hinkle.spring5Demo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
