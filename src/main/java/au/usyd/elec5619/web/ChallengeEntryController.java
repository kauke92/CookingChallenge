package au.usyd.elec5619.web;


import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import au.usyd.elec5619.domain.ChallengeEntry;
import au.usyd.elec5619.service.ChallengeEntryManager;
import au.usyd.elec5619.service.UserManager;

@Controller
@RequestMapping(value="/challengeentry/**")
public class ChallengeEntryController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Resource(name="challengeentryManager")
	private ChallengeEntryManager challengeentryManager;

	@Resource(name="userManager")
	private UserManager userManager;

	//	@RequestMapping(value="/")
	//	public String link(Model uiModel) {

	//		return "/home";
	//	}

	@RequestMapping(value="/addchallengeentry")
	public String addChallengeEntry(Model uiModel) {
		ChallengeEntry challengeentry = new ChallengeEntry();
		uiModel.addAttribute("challengeentry", challengeentry);

		return "challenge/addchallengeentry";
	}

	//Needs to get information from the challenge to display on the form
	@RequestMapping(value="/{id}/submit", method=RequestMethod.GET)
	public String challengeChallengeEntry(@PathVariable("id") long id, Model uiModel) {
		System.out.println("challengeChallengeEntryhere");
		ChallengeEntry challengeentry = new ChallengeEntry();
		uiModel.addAttribute("challengeentry", challengeentry);
		return "challenge/addchallengeentry";
	}

	/*@RequestMapping(value="/{id}/submit", method=RequestMethod.POST)
	public String challengeChallengeEntry(@PathVariable("id") long id, @Valid ChallengeEntry challengeentry, BindingResult result, @RequestParam String action) {
		if(action.equals("Cancel")) {
		} else {
			if(result.hasErrors()) {
				return "challenge/addchallengeentry";
			}
			Date date = new Date();
			if(challengeentry.getDatecreated().equals("")) {
				challengeentry.setDatecreated(date.toString());
			}
			challengeentry.setUser(this.userManager.getUserById(id));
			challengeentry.setDatesubmitted(date.toString());
			this.challengeentryManager.updateChallengeEntry(challengeentry);
			System.out.println(challengeentry.getId());
		}
		return "redirect:/user/" + id + "/profile";
	}

	@RequestMapping(value="/{id}/searchchallengeentries", method=RequestMethod.GET)
	public String yourChallengeEntrys(@PathVariable("id") long id, Model uiModel) {
		Set<ChallengeEntry> challengeentries = this.userManager.getUserById(id).getChallengeEntries();
		uiModel.addAttribute("challengeentries", challengeentries);

		return "challenge/searchchallengeentries";
	}*/

	@RequestMapping(value="/allchallengeentries", method=RequestMethod.GET)
	public String allChallengeEntrys(Model uiModel) {
		
		//	queryChallengeEntrys("author", )
		List<ChallengeEntry> challengeentries = this.challengeentryManager.getChallengeEntries();
		uiModel.addAttribute("challengeentries", challengeentries);

		return "challenge/searchchallengeentries";
	}

}