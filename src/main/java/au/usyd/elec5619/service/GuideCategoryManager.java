package au.usyd.elec5619.service;

import java.util.List;

import au.usyd.elec5619.domain.Guide;
import au.usyd.elec5619.domain.GuideCategory;

public interface GuideCategoryManager {
	public List<GuideCategory>  getGuideCategories();
	
	//public void addGuide(Guide guide);
	
	public GuideCategory getGuideCategoryById(long id);
	
	//public void updateGuide(Guide guide);
	
	//public void deleteGuide(long id);

}
