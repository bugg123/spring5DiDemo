package test.hinkle.spring5Demo.repositories;

import org.springframework.data.repository.CrudRepository;
import test.hinkle.spring5Demo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
