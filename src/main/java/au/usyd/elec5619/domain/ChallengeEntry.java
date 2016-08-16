package au.usyd.elec5619.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ChallengeEntry")
public class ChallengeEntry extends Submission {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8884769549114692481L;

	
	
	
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;
	

	@Column(name="Tag")
	private String tag;
	
	@Column(name="DateSubmitted")
	private String datesubmitted;
	
	@Column(name="Pictures")
	private String pictures;
	
	@Column(name="VideoUrl")
	private String videourl;
	
	@Column(name="IngredientList")
	private String ingredientlist;
	
	@Column(name="ReviewList")
	private String reviewlist;
	
	

	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	

	
	public void setDatesubmitted(String datesubmitted) {
		this.datesubmitted = datesubmitted;
	}
	
	public String getPictures() {
		return pictures;
	}
	
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	
	public String getVideourl() {
		return videourl;
	}
	
	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	
	public String getIngredientlist() {
		return ingredientlist;
	}
	
	public void setIngredientlist(String ingredientlist) {
		this.ingredientlist = ingredientlist;
	}
	
	
	public String getReviewlist() {
		return reviewlist;
	}
	
	public void setReviewlist(String reviewlist) {
		this.reviewlist = reviewlist;
	}
	
	

	
}