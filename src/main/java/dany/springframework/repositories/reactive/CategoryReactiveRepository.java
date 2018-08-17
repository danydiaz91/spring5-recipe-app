package dany.springframework.repositories.reactive;

import dany.springframework.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReactiveRepository extends ReactiveMongoRepository<Category, String> {
}
