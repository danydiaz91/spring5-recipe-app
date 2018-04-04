package dany.springframework.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dany.springframework.domain.Category;
import dany.springframework.domain.UnitOfMeasure;
import dany.springframework.repositories.CategoryRepository;
import dany.springframework.repositories.RecipeRepository;
import dany.springframework.repositories.UnitOfMeasureRepository;
import dany.springframework.services.RecipeService;

/**
 * 
 * @author Dany Diaz
 *
 */
@Controller
public class IndexController {

	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {				
		model.addAttribute("recipes", recipeService.getRecipes());		
		return "index";
	}
}
