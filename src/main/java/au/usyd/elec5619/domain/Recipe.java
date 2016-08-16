package au.usyd.elec5619.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Recipe")
public class Recipe extends Submission {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4962476041704330252L;

	@Column(name="IngredientList")
	@NotBlank
	private String ingredientList;
	

	@Column(name="Instructions")
	@NotBlank
	private String instructions;
	
	

	
	public String getIngredientList() {
		return ingredientList;
	}
	
	public void setIngredientList(String ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	public String getInstructions() {
		return instructions;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}


}