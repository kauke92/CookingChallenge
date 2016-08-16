package au.usyd.elec5619.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.Recipe;

@Service(value="recipeManager")
@Transactional
public class DatabaseRecipeManager implements RecipeManager {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<Recipe> searchRecipes(String search){
		String str = "%" + search + "%";
		return this.sessionFactory.getCurrentSession().createCriteria(Recipe.class).
				add(Restrictions.like("title", str)).list();
	}


	
	public void addRecipe(Recipe recipe) {
		this.sessionFactory.getCurrentSession().save(recipe);
		
	}

	public Recipe getRecipeById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Recipe recipe = (Recipe) currentSession.get(Recipe.class, id);
		return recipe;
	}
	

	public void updateRecipe(Recipe recipe) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(recipe);
	}
	
	public void deleteRecipe(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Recipe recipe = (Recipe) currentSession.get(Recipe.class, id);
		currentSession.delete(recipe);
	}


	public List<Recipe> getRecipes() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Recipe").list();
	}
	
	

	
}
