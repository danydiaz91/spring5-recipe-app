/**
 * 
 */
package dany.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import dany.springframework.domain.Recipe;

/**
 * @author Dany Diaz
 *
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
