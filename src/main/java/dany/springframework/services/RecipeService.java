package dany.springframework.services;

import java.util.Set;

import dany.springframework.domain.Recipe;

/**
 * 
 * @author Dany Diaz
 *
 */
public interface RecipeService {

	Set<Recipe> getRecipes();
}
