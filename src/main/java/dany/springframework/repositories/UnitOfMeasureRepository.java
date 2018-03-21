package dany.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import dany.springframework.domain.UnitOfMeasure;

/**
 * 
 * @author Dany Diaz
 *
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

}
