package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Submission")
public class Submission implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7707226817473671558L;

	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	@Column(name="Title")
	@NotBlank
	private String title;
	
//	@Column(name="Price")
//	private Double price;
	

	@Column(name="Author")
	private String author;
	
	@Column(name="DateCreated")
	private String datecreated;
	
	@Column(name="Description")
	@NotBlank
	private String description;
	
	
	@Column(name="Ratings")
	
	private int rating;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDatecreated() {
		return datecreated;
	}
	
	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: + " + description + ";");
	//	buffer.append("Price; " + price);
		return buffer.toString();
	}

}