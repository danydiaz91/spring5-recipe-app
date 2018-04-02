/**
 * 
 */
package dany.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dany.springframework.domain.Category;

/**
 * @author Dany Diaz
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);
}
