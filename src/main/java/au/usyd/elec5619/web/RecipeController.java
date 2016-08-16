package au.usyd.elec5619.web;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import au.usyd.elec5619.domain.Recipe;
import au.usyd.elec5619.service.RecipeManager;

@Controller
@RequestMapping(value="/cookbook/**")
public class RecipeController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Resource(name="recipeManager")
	private RecipeManager recipeManager;

	@RequestMapping(value = "/cookbook")
	public String cookBook(Model uiModel) {
		List<Recipe> recipes = this.recipeManager.getRecipes();
		uiModel.addAttribute("recipes", recipes);
		return "cookbook";
	}

	@RequestMapping(value="/addrecipe")
	public String addRecipe(Model uiModel) {
		Recipe recipe = new Recipe();
		uiModel.addAttribute("recipe", recipe);

		return "addrecipe";
	}


	@RequestMapping(value="/addrecipe", method=RequestMethod.POST)
	public String addRecipe(@Valid Recipe recipe, BindingResult result, @RequestParam String action, Model m) {
		if(action.equals("Cancel")) {
			return "redirect:/cookbook";
		} else {
			if(result.hasErrors()) {
				return "addrecipe";
			}
			Date date = new Date();
			recipe.setDatecreated(date.toString());
			recipe.setAuthor("username");
			recipe.setRating(0);
			this.recipeManager.addRecipe(recipe);
			System.out.println(recipe.getId());
		}
		long id = recipe.getId();

		return "redirect:/cookbook/" + id + "/viewrecipe";
	}

	@RequestMapping(value="/{id}/viewrecipe")
	public String viewRecipe(@PathVariable("id") long id, Model uiModel) {
		Recipe recipe = this.recipeManager.getRecipeById(id);
		if(recipe == null){
			return "cookbook";
		}
		uiModel.addAttribute("recipe", recipe);
		return "viewrecipe";
	}



	@RequestMapping(value="/{id}/editrecipe", method=RequestMethod.GET)
	public String editRecipe(@PathVariable("id") long id, Model uiModel) {
		Recipe recipe = this.recipeManager.getRecipeById(id);
		uiModel.addAttribute("recipe", recipe);	
		return "editrecipe";
	}

	@RequestMapping(value="/{id}/editrecipe/**", method=RequestMethod.POST)
	public String editRecipe(@PathVariable("id") long id, @Valid Recipe recipe, BindingResult result, @RequestParam String action) {
		if(action.equals("Cancel")) {
		} else {
			if(result.hasErrors()) {
				return "editrecipe";
			}
			this.recipeManager.updateRecipe(recipe);
			System.out.println(recipe.getId());
		}
		return "redirect:/cookbook/" + id + "/viewrecipe";
	}


	@RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
	public String deleteRecipe(@PathVariable("id") long id) {
		this.recipeManager.deleteRecipe(id);
		return "redirect:/cookbook/";
	}

	@RequestMapping(value="/searchrecipe")
	public String searchRecipe() {
		return "searchrecipe";
	}


	@RequestMapping(value="/searchrecipe", method=RequestMethod.POST)
	public String searchRecipe(String search, @RequestParam String action, Model uiModel) {
		List<Recipe> recipes = this.recipeManager.searchRecipes(search);

		uiModel.addAttribute("recipes", recipes);
		uiModel.addAttribute("search", search);
		return "searchrecipe";

	}

}
