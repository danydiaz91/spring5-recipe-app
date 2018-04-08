package dany.springframework.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Dany Diaz
 * @date 2018-03-12
 *
 */
@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	
	@Column(length = 2000)
	private String directions;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();
	
	@Lob
	private Byte[] image;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;
	
	@ManyToMany
	@JoinTable(name = "recipe_category", 
		joinColumns = @JoinColumn(name = "recipe_id"), 
		inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public Recipe setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getPrepTime() {
		return prepTime;
	}

	public Recipe setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
		return this;
	}

	public Integer getCookTime() {
		return cookTime;
	}

	public Recipe setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
		return this;
	}

	public Integer getServings() {
		return servings;
	}

	public Recipe setServings(Integer servings) {
		this.servings = servings;
		return this;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUrl() {
		return url;
	}

	public Recipe setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getDirections() {
		return directions;
	}

	public Recipe setDirections(String directions) {
		this.directions = directions;
		return this;
	}
	
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public Recipe setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
		return this;
	}

	public Byte[] getImage() {
		return image;
	}

	public Recipe setImage(Byte[] image) {
		this.image = image;
		return this;
	}

	public Notes getNotes() {
		return notes;
	}

	public Recipe setNotes(Notes notes) {
		notes.setRecipe(this);
		this.notes = notes;
		return this;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public Recipe setCategories(Set<Category> categories) {
		this.categories = categories;
		return this;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public Recipe setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
		return this;
	}	
	
	public Recipe addIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this);
		ingredients.add(ingredient);
		return this;
	}
	
	public Recipe addCategory(Category category) {
		categories.add(category);
		return this;
	}
}
