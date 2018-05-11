/**
 * 
 */
package dany.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dany.springframework.domain.Category;
import dany.springframework.domain.Difficulty;
import dany.springframework.domain.Ingredient;
import dany.springframework.domain.Notes;
import dany.springframework.domain.Recipe;
import dany.springframework.domain.UnitOfMeasure;
import dany.springframework.repositories.CategoryRepository;
import dany.springframework.repositories.RecipeRepository;
import dany.springframework.repositories.UnitOfMeasureRepository;

/**
 * @author Dany Diaz
 *
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	
	public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}
	
	private List<Recipe> getRecipes() {
		List<Recipe> recipes = new ArrayList<>(2);
		
		//UOMS		
		Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
		Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");		
		Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");
				
		UnitOfMeasure eachUom = eachUomOptional.orElseThrow(() -> new RuntimeException("Expected UOM Not Found"));
		UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.orElseThrow(() -> new RuntimeException("Expected UOM Not Found"));
		UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.orElseThrow(() -> new RuntimeException("Expected UOM Not Found"));
		UnitOfMeasure dashUom = dashUomOptional.orElseThrow(() -> new RuntimeException("Expected UOM Not Found"));		
		UnitOfMeasure cupsUom = cupsUomOptional.orElseThrow(() -> new RuntimeException("Expected UOM Not Found"));
		
		// Categories
		Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");		
		Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
		
		Category americanCategory = americanCategoryOptional.orElseThrow(() -> new RuntimeException("Expected Category Not Found"));
		Category mexicanCategory = mexicanCategoryOptional.orElseThrow(() -> new RuntimeException("Expected Category Not Found"));
		
		//Guacamole		
		Recipe guacamoleRecipe = new Recipe()
				.setDescription("Perfect Guacamole")
				.setPrepTime(10)
				.setCookTime(0)
				.setDifficulty(Difficulty.EASY)
				.setDirections("1. Cut avocado, remove flesh: Cut the avocados in half. Remove seed. "
				+ "Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. "
				+ "2. Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.) "
				+ "3. Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will "
				+ "provide some balance to the richness of the avocado and will help delay the avocados from turning brown. "
				+ "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, "
				+ "start with a half of one chili pepper and add to the guacamole to your desired degree of hotness. "
				+ "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste. "
				+ "4. Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. "
				+ "(The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve. "
				+ "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
		
		Notes guacamoleNotes = new Notes();		
		guacamoleNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados. "
				+ "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it "
				+ "(a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries. "
				+ "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other "
				+ "ingredients stop you from making guacamole. "
				+ "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, "
				+ "but so what? It tastes great. ");
		
		guacamoleRecipe.setNotes(guacamoleNotes);
		
		guacamoleRecipe.addIngredient(new Ingredient("Ripe Avocados", new BigDecimal(2), eachUom))
				.addIngredient(new Ingredient("Kosher Salt", new BigDecimal(".5"), teaSpoonUom))
				.addIngredient(new Ingredient("Fresh Lime Juice or Lemon Juice", new BigDecimal(2), tableSpoonUom))
				.addIngredient(new Ingredient("Minced Red Onion Or Thinly Sliced Green Onion", new BigDecimal(2), tableSpoonUom))
				.addIngredient(new Ingredient("Serrano Chiles, stems and Seeds Removed, Minced", new BigDecimal(2), eachUom))
				.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tableSpoonUom))
				.addIngredient(new Ingredient("Freshly Grated Black Pepper", new BigDecimal(2), dashUom))
				.addIngredient(new Ingredient("Ripe Tomato, Seeds and Pulp Removed, Chopped", new BigDecimal(".5"), eachUom));

		guacamoleRecipe.addCategory(americanCategory)
				.addCategory(mexicanCategory);
		
		recipes.add(guacamoleRecipe);
		
		//Tacos
		Recipe tacosRecipe = new Recipe()
			.setDescription("Spicy Grilled Chicken Taco")
			.setCookTime(9)
			.setPrepTime(20)
			.setDifficulty(Difficulty.MODERATE)
			.setDirections("1. Prepare a gas or charcoal grill for medium-high, direct heat. "
				+ "2. Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, "
				+ "garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over. "
				+ "Set aside to marinate while the grill heats and you prepare the rest of the toppings. "
				+ "3. Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat "
				+ "registers 165F. Transfer to a plate and rest for 5 minutes. "
				+ "4. Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air "
				+ "start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side. Wrap warmed tortillas in a tea towel to "
				+ "keep them warm until serving. "
				+ "5. Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, "
				+ "radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges. ");
		
		Notes tacosNotes = new Notes();
		tacosNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla. "
				+ "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night "
				+ "snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house. "
				+ "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack! "
				+ "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. "
				+ "You can also use this time to prepare the taco toppings. "
				+ "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together "
				+ "in about 30 minutes!");
		
		tacosRecipe.setNotes(tacosNotes);
		
		tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tableSpoonUom))
				.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoonUom))
				.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoonUom))
				.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaSpoonUom))
				.addIngredient(new Ingredient("Salt", new BigDecimal(5), teaSpoonUom))
				.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), eachUom))
				.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSpoonUom))
				.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoonUom))
				.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tableSpoonUom))
				.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tableSpoonUom))
				.addIngredient(new Ingredient("small corn tortillas", new BigDecimal(8), eachUom))
				.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cupsUom));
		
		tacosRecipe.addCategory(americanCategory)
				.addCategory(mexicanCategory);
		
		recipes.add(tacosRecipe);
		
		return recipes;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		recipeRepository.saveAll(getRecipes());		
	}
}
