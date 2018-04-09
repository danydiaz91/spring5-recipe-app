package dany.springframework.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * 
 * @author Dany Diaz
 * @date 2018-03-12
 *
 */
@Entity
@Data
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
}
