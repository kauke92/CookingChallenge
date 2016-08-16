package au.usyd.elec5619.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name="Review")
public class Review implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8652039500629184623L;

	@Id
	@GeneratedValue
	@Column(name="ReviewId")
	private long id;
	
	@Column(name="Datecreated")
	private String datecreated;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Author")
	private String author;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Tag")
	private String tag;
	
	@Column(name="Ratings")
	private String ratings;
	
	@ManyToOne
	@JoinColumn(name="Id")
	private Challenge challenge;

	@Column(name="Ids")
	private long ids;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public long getIds() {
		return ids;
	}

	public void setIds(long ids) {
		this.ids = ids;
	}
	
}