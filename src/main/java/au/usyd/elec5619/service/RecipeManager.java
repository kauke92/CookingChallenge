package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.Recipe;

public interface RecipeManager extends Serializable {
	
//	public void increasePrice(int percentage);
	
	public List<Recipe> getRecipes();
	
	public void addRecipe(Recipe recipe);
	
	public Recipe getRecipeById(long id);
	
	public void updateRecipe(Recipe recipe);
	
	public void deleteRecipe(long id);
	
	public List<Recipe> searchRecipes(String search);
	
	
	//public void storeUserImage(User userById, byte[] read);
}
