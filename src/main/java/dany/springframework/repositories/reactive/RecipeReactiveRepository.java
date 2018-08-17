package dany.springframework.repositories.reactive;

import dany.springframework.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
