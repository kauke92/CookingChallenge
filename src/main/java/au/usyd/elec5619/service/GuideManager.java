package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.Guide;

public interface GuideManager extends Serializable{
	
	public List<Guide>  getGuides();
	
	public void addGuide(Guide guide);
	
	public Guide getGuideById(long id);
	
	public void updateGuide(Guide guide);
	
	public void deleteGuide(long id);
	
	public List<Guide> getGuidesByCategoryId(long id); 

}
