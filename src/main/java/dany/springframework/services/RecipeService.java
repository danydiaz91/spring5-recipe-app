package dany.springframework.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import dany.springframework.domain.Recipe;

/**
 * 
 * @author Dany Diaz
 *
 */
@Service
public interface RecipeService {

	Set<Recipe> getRecipes();
}
