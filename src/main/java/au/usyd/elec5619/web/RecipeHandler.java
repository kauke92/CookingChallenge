package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import au.usyd.elec5619.service.RecipeManager;

public class RecipeHandler implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private RecipeManager recipeManager;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String now = (new java.util.Date()).toString();
		logger.info("returning recipe view with " + now);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("recipes", this.recipeManager.getRecipes());
		
		return new ModelAndView("cookbook", "model", myModel);
		
	}
	
	public void setRecipeManager(RecipeManager recipeManager) {
		this.recipeManager = recipeManager;
	}
}
