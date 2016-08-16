package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="Challenge")
public class Challenge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4877544456731655281L;

	

	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	@Column(name="Title")
	@NotBlank
	private String titlec;
	
	@Column(name="Description")
	private String descriptionc;
	
	@Column(name="Datecreated")
	private String datecreatedc;
	
	@Column(name="Datefinished")
	private String datefinishedc;
	
	@Column(name="Rules")
	private String rulesc;

	@Column(name="Ingredients")
	private ArrayList<String> ingredients;
	
	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinColumn(name="Id")
	private List<Review> reviews;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitlec() {
		return titlec;
	}

	public void setTitlec(String titlec) {
		this.titlec = titlec;
	}

	public String getDescriptionc() {
		return descriptionc;
	}

	public void setDescriptionc(String descriptionsc) {
		this.descriptionc = descriptionsc;
	}

	public String getDatecreatedc() {
		return datecreatedc;
	}

	public void setDatecreatedc(String datecreatedc) {
		this.datecreatedc = datecreatedc;
	}

	public String getDatefinishedc() {
		return datefinishedc;
	}

	public void setDatefinishedc(String datefinishedc) {
		this.datefinishedc = datefinishedc;
	}

	public String getRulesc() {
		return rulesc;
	}

	public void setRulesc(String rulesc) {
		this.rulesc = rulesc;
	}

	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<String>  ingredients) {
		this.ingredients = ingredients;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
