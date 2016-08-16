package au.usyd.elec5619.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "User")
public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "UserId")
	private long id;

	@Column(name = "Description")
	private String description;

	@Column(name = "Username", unique = true)
	@NotBlank
	private String username;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	@Column(name = "Password")
	@NotBlank
	private String password;

	@Column(name = "Confirmpassword")
	@NotBlank
	private String confirmpassword;

	@Column(name = "Enabled", nullable = false)
	private boolean enabled = true;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	public Set<Guide> getGuides() {
		return guides;
	}
	
	public void addGuide(Guide guide) {
		guides.add(guide);
		
	}
	public void setGuides(Set<Guide> guides) {
		this.guides = guides;
	}

	@Column(name = "FirstName")
	@NotBlank
	private String firstname;

	@Column(name = "LastName")

	private String lastname;

	@Column(name = "EmailAddress")
	@Email
	@NotBlank
	private String emailaddress;

	@Column(name = "Location")
	private String location;

	@Column(name = "DateCreated")
	private String datecreated;

	@Column(name = "Reviews")
	private String reviews;

	@Column(name = "Favourites")
	private String favourites;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<ChallengeEntry> challengeentries;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "guideAuthor")
	private Set<Guide> guides;
	
	@Column(name = "ProfileImageLocation")
	private String profileimagelocation;

	// @Column(name="ProfileImage")
	// private File profileimage;

	@Column(name = "UserSettings")
	private String usersettings;

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

	/*
	 * public Double getPrice() { return price; }
	 * 
	 * public void setPrice(Double price) { this.price = price; }
	 */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		checkPassword();
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
		checkPassword();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public Set<ChallengeEntry> getChallengeEntries() {
		return challengeentries;
	}

	public void setChallengeEntries(Set<ChallengeEntry> challengeentries) {
		this.challengeentries = challengeentries;
	}

	public String getProfileimagelocation() {
		return profileimagelocation;
	}

	public void setProfileimagelocation(String profileimagelocation) {
		this.profileimagelocation = profileimagelocation;
	}

	// public Blob getProfileimage() {
	// return profileimage;
	// }

	// public void setProfileimage(Blob profileimage) {
	// this.profileimage = profileimage;
	// }

	public String getUsersettings() {
		return usersettings;
	}

	public void setUsersettings(String usersettings) {
		this.usersettings = usersettings;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: + " + description + ";");
		// buffer.append("Price; " + price);
		return buffer.toString();
	}

	public void checkPassword() {
		if (this.password == null || this.confirmpassword == null) {
			return;
		} else if (!this.password.equals(confirmpassword)) {
			this.confirmpassword = null;
		}
	}

}