package dany.springframework.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import dany.springframework.domain.Recipe;
import dany.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Dany Diaz
 *
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
		
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		log.info("Getting recipes");
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().forEach(recipeSet::add);
		return recipeSet;
	}

}
