package au.usyd.elec5619.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.usyd.elec5619.domain.Challenge;
import au.usyd.elec5619.service.ChallengeManager;


@Controller
@RequestMapping(value="/challenge/**")
public class ChallengeController {
	
	@Resource(name="challengeManager")
	private ChallengeManager challengeManager;

	@RequestMapping(value="/addchallenge")
	public String addChallenge(Model uiModel) {
		
		return "addchallenge";
	}
	
	@RequestMapping(value="/addchallenge", method=RequestMethod.POST)
	public String addChallenge(HttpServletRequest httpServletRequest) {
		
		Challenge challenge = new Challenge();
		Date now = new Date();
		challenge.setDatecreatedc(now.toString());
		int duration = 0;
		try  
		  {  
			duration = Integer.parseInt(httpServletRequest.getParameter("duration").toString());		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    duration = 14;  
		  }  
		
		for(int i = 0; i < duration; i++){
			now = new Date(now.getTime() + (1000 * 60 * 60 * 24));
		}
		challenge.setDatefinishedc(now.toString());
		challenge.setDescriptionc(httpServletRequest.getParameter("description"));
		challenge.setRulesc(httpServletRequest.getParameter("rules"));
		challenge.setTitlec(httpServletRequest.getParameter("title"));
		
		String ingredientString = httpServletRequest.getParameter("ingredients");
		challenge.setIngredients(ingredientsToArrayList(ingredientString));

		this.challengeManager.addChallenge(challenge);
		
		return "redirect:/challenge";
	}
	
	private ArrayList<String> ingredientsToArrayList(String ingredientString) {
		String [] ingredients = ingredientString.split("\r?\n|\r");
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i< ingredients.length; i++){
			if(ingredients[i].contains(",")){
				String [] temp2 = ingredients[i].split(",");
				for(int j = 0; j < temp2.length; j ++){
					list.add(temp2[j]);
				}
				
			} else {
				list.add(ingredients[i]);
			}
		}
		
		return list;
	}

	@RequestMapping(value="/editchallenge/{id}", method=RequestMethod.GET)
	public String editChallenge(@PathVariable("id") Long id, Model uiModel) {
		
		Challenge challenge = this.challengeManager.getChallengeById(id);
		uiModel.addAttribute("challenge", challenge);
		
		return "editchallenge";
	}
	
	
	@RequestMapping(value="/editchallenge/**", method=RequestMethod.POST)
	public String editChallenge(Challenge challenge) {
		
		this.challengeManager.updateChallenge(challenge);
		return "redirect:/challenge";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String editChallenge(@PathVariable("id") Long id) {
		
		this.challengeManager.deleteChallenge(id);
		
		return "redirect:/challenge";
	}
	
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public String viewChallenge(@PathVariable("id") Long id) {
		String temp = "redirect:/viewchallenge";
		temp+= (("?id=")+id);
		return temp;
	}
}
