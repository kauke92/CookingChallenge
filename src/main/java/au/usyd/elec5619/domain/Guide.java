package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Guide")
public class Guide implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7572934034994992191L;

	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	@Column(name="GuideTitle")
	private String guideTitle;
	
	@Column(name="GuideDescription")
	private String guideDescription;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="UserId")
	private User guideAuthor;
	
	@Column(name="GuideCategory")
	private long guideCategory;
	
	@Column(name="DateCreated")
	private Date dateCreated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGuideTitle() {
		return guideTitle;
	}

	public void setGuideTitle(String guideTitle) {
		this.guideTitle = guideTitle;
	}

	public String getGuideDescription() {
		return guideDescription;
	}

	public void setGuideDescription(String guideDescription) {
		this.guideDescription = guideDescription;
	}

	public User getGuideAuthor() {
		return guideAuthor;
	}

	public void setGuideAuthor(User guideAuthor) {
		this.guideAuthor = guideAuthor;
	}

	public long getGuideCategory() {
		return guideCategory;
	}

	public void setGuideCategory(long guideCategory) {
		this.guideCategory = guideCategory;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
