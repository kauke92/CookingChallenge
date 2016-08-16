package au.usyd.elec5619.web;

import java.sql.Date;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.SimpleFormController;

import au.usyd.elec5619.dao.LoginDao;
import au.usyd.elec5619.domain.Guide;
import au.usyd.elec5619.domain.GuideCategory;
import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.DatabaseGuideManager;
import au.usyd.elec5619.service.GuideValidator;
import au.usyd.elec5619.service.LoggedUserDetails;
import au.usyd.elec5619.service.SimpleGuideCategoryManager;
import au.usyd.elec5619.service.UserValidator;
@Transactional
@Controller
@RequestMapping(value = "/guide/**")
public class GuideController {
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	GuideValidator guideValidator;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(guideValidator);
	}

	@Resource(name = "guideManager")
	private DatabaseGuideManager guideManager;

	@Resource(name = "guideCategoryManager")
	private SimpleGuideCategoryManager guideCategoryManager;

	@RequestMapping(value = "/add")
	public String addGuide(@ModelAttribute("guide") Guide guide, Model uiModel) {

		Map<Long, String> guideCategory = new LinkedHashMap<Long, String>();

		for (GuideCategory g : this.guideCategoryManager.getGuideCategories()) {
			guideCategory.put(g.getId(), g.getGuideCategoryName());
		}

		uiModel.addAttribute("categoryList", guideCategory);
		return "addguide";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addGuide(@Valid Guide guide, BindingResult result, Model uiModel) {
		if (result.hasErrors()) {

			Map<Long, String> guideCategory = new LinkedHashMap<Long, String>();

			for (GuideCategory g : this.guideCategoryManager.getGuideCategories()) {
				guideCategory.put(g.getId(), g.getGuideCategoryName());
			}

			uiModel.addAttribute("categoryList", guideCategory);
			return "addguide";
		}
		User user = ((LoggedUserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal()).getUser();
		guide.setGuideAuthor(user);
		user.addGuide(guide);

		guide.setDateCreated(new Date(System.currentTimeMillis()));
		
		this.guideManager.addGuide(guide);
		long id = guide.getId();
		return "redirect:/guide/" + id;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editGuide(@PathVariable("id") Long id, Model uiModel) {
		Guide guide = this.guideManager.getGuideById(id);

		Map<Long, String> guideCategory = new LinkedHashMap<Long, String>();

		for (GuideCategory g : this.guideCategoryManager.getGuideCategories()) {
			guideCategory.put(g.getId(), g.getGuideCategoryName());
		}

		uiModel.addAttribute("categoryList", guideCategory);

		uiModel.addAttribute("guide", guide);
		return "editguide";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String editGuide(@Valid Guide guide) {
		this.guideManager.updateGuide(guide);
		System.out.println(guide.getId());
		return "redirect:/guide/" + guide.getId();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteGuide(@PathVariable("id") Long id) {
		this.guideManager.deleteGuide(id);
		return "redirect:/guidelines";
	}

	@RequestMapping(value = "/{id}")
	public String viewGuide(@PathVariable("id") long id, Model uiModel) {
		Guide guide = this.guideManager.getGuideById(id);
		String categoryTitle = guideCategoryManager.getGuideCategoryById(guide.getGuideCategory())
				.getGuideCategoryName();
		uiModel.addAttribute("guide", guide);
		uiModel.addAttribute("categoryTitle", categoryTitle);
		uiModel.addAttribute("author", guide.getGuideAuthor());
		return "guide";
	}

}
