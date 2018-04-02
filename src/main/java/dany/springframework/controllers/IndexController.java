package dany.springframework.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dany.springframework.domain.Category;
import dany.springframework.domain.UnitOfMeasure;
import dany.springframework.repositories.CategoryRepository;
import dany.springframework.repositories.UnitOfMeasureRepository;

/**
 * 
 * @author Dany Diaz
 *
 */
@Controller
public class IndexController {

	private CategoryRepository CategoryRepository;
	private UnitOfMeasureRepository UnitOfMeasureRepository;

	public IndexController(dany.springframework.repositories.CategoryRepository categoryRepository,
			dany.springframework.repositories.UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		CategoryRepository = categoryRepository;
		UnitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		Optional<Category> categoryOptional = CategoryRepository.findByDescription("Mexican");
		Optional<UnitOfMeasure> unitOfMeasureOptional = UnitOfMeasureRepository.findByDescription("Teaspoon");
		
		System.out.println("Category ID: " + categoryOptional.get().getId());
		System.out.println("Unit Of Measure ID: " + unitOfMeasureOptional.get().getId());
		
		return "index";
	}
}
