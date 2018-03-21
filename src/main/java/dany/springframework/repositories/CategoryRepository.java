/**
 * 
 */
package dany.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import dany.springframework.domain.Category;

/**
 * @author Dany Diaz
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
