package au.usyd.elec5619.service;

import java.util.List;

import au.usyd.elec5619.domain.GuideCategory;

public class SimpleGuideCategoryManager implements GuideCategoryManager {
	
	List<GuideCategory> guideCategoryList;
	@Override
	public List<GuideCategory> getGuideCategories() {
		return guideCategoryList;
	}

	@Override
	public GuideCategory getGuideCategoryById(long id) {
		for (GuideCategory g:guideCategoryList ) {
			if (g.getId()==id) {
				return g;
			}
		}
		return null;
	}

	public List<GuideCategory> getGuideCategoryList() {
		return guideCategoryList;
	}

	public void setGuideCategoryList(List<GuideCategory> guideCategoryList) {
		this.guideCategoryList = guideCategoryList;
	}

}
