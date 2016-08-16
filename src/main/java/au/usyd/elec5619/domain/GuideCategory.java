package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GuideCategory")
public class GuideCategory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6747120433495232478L;

	@Id
	@Column(name="Id")
	private long id;
	
	@Column(name="CategoryName")
	private String guideCategoryName;
	
	@Column(name="CategoryDescription")
	private String guideCategoryDescription;
	
//	@Column(name="GuideList")
//	private List<Guide> guideList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGuideCategoryName() {
		return guideCategoryName;
	}

	public void setGuideCategoryName(String guideCategoryName) {
		this.guideCategoryName = guideCategoryName;
	}

	public String getGuideCategoryDescription() {
		return guideCategoryDescription;
	}

	public void setGuideCategoryDescription(String guideCategoryDescription) {
		this.guideCategoryDescription = guideCategoryDescription;
	}

//	public List<Guide> getGuideList() {
//		return guideList;
//	}
//
//	public void setGuideList(List<Guide> guideList) {
//		this.guideList = guideList;
//	}

	
	
	
}
