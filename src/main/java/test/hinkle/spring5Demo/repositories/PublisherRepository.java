package test.hinkle.spring5Demo.repositories;

import org.springframework.data.repository.CrudRepository;
import test.hinkle.spring5Demo.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
