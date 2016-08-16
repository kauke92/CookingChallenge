package au.usyd.elec5619.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import au.usyd.elec5619.domain.Guide;
import au.usyd.elec5619.domain.GuideCategory;
import au.usyd.elec5619.service.DatabaseGuideManager;
import au.usyd.elec5619.service.SimpleGuideCategoryManager;

@Controller
@RequestMapping(value="/guidelines/category/**")
public class GuideCategoryController {
	
	@Resource (name="guideCategoryManager")
	private SimpleGuideCategoryManager guideCategoryManager;
	@Resource (name="guideManager")
	private DatabaseGuideManager guideManager;
	@RequestMapping(value="/{id}")
	public String viewGuide(@PathVariable("id") long id, Model uiModel) {
		GuideCategory guideCategory  = this.guideCategoryManager.getGuideCategoryById(id);
		List<Guide> guides = this.guideManager.getGuidesByCategoryId(id);
		uiModel.addAttribute("guideCategory", guideCategory);
		uiModel.addAttribute("guides", guides);
		return "category";
	}
}
