package dany.springframework.services;

import java.util.HashSet;
import java.util.Set;

import dany.springframework.domain.Recipe;
import dany.springframework.repositories.RecipeRepository;

/**
 * 
 * @author Dany Diaz
 *
 */
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
		
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().forEach(recipeSet::add);
		return recipeSet;
	}

}
