/**
 * 
 */
package dany.springframework.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Dany Diaz
 *
 */
public class CategoryTest {

	private Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	/**
	 * Test method for {@link dany.springframework.domain.Category#getId()}.
	 */
	@Test
	public void testGetId() {
		Long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}

	/**
	 * Test method for {@link dany.springframework.domain.Category#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		String descriptionValue = "Description";
		category.setDescription(descriptionValue);
		assertEquals(descriptionValue, category.getDescription());
	}

	/**
	 * Test method for {@link dany.springframework.domain.Category#getRecipes()}.
	 */
	@Test
	public void testGetRecipes() {
		Set<Recipe> recipes = new HashSet<>();
		category.setRecipes(recipes);
		assertEquals(recipes, category.getRecipes());
	}

}
