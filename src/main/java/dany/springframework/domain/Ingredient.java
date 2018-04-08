package dany.springframework.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * 
 * @author Dany Diaz
 * @date 2018-03-12
 *
 */
@Entity
public class Ingredient {
	
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeas) {
		super();
		this.description = description;
		this.amount = amount;
		this.unitOfMeas = unitOfMeas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private BigDecimal amount;
	
	@ManyToOne
	private Recipe recipe;
	
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure unitOfMeas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public UnitOfMeasure getUnitOfMeas() {
		return unitOfMeas;
	}

	public void setUnitOfMeas(UnitOfMeasure unitOfMeas) {
		this.unitOfMeas = unitOfMeas;
	}	
}
