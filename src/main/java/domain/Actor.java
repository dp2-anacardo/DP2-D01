
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.hibernate.validator.constraints.URL;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
@Table(indexes = {
	@Index(columnList = "isSuspicious, isBanned")
})
public abstract class Actor extends DomainEntity {

	private String						name;
	private String						photo;
	private String						email;
	private String						phoneNumber;
	private String						address;
	private Boolean						isSuspicious;
	private Boolean						isBanned;
	private Double						score;

	//Relationships

	private Collection<MessageBox>		boxes;
	private UserAccount					userAccount;
	private Collection<SocialProfile>	socialProfiles;


	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getName() {
		return this.name;
	}

	@URL
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getPhoto() {
		return this.photo;
	}

	@NotBlank
	@Email
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getEmail() {
		return this.email;
	}

	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getAddress() {
		return this.address;
	}

	public Boolean getIsSuspicious() {
		return this.isSuspicious;
	}

	public Boolean getIsBanned() {
		return this.isBanned;
	}
	@Range(min = -1, max = 1)
	public Double getScore() {
		return this.score;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPhoto(final String photo) {
		this.photo = photo;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public void setIsSuspicious(final Boolean isSuspicious) {
		this.isSuspicious = isSuspicious;
	}

	public void setIsBanned(final Boolean isBanned) {
		this.isBanned = isBanned;
	}

	public void setScore(final Double score) {
		this.score = score;
	}

	//Relationships

	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	public Collection<MessageBox> getBoxes() {
		return this.boxes;
	}

	@Valid
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	@Valid
	@OneToMany
	public Collection<SocialProfile> getSocialProfiles() {
		return this.socialProfiles;
	}

	public void setBoxes(final Collection<MessageBox> boxes) {
		this.boxes = boxes;
	}

	public void setUserAccount(final UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public void setSocialProfiles(final Collection<SocialProfile> socialProfiles) {
		this.socialProfiles = socialProfiles;
	}

	public MessageBox getMessageBox(final String name) {
		final MessageBox result = null;
		for (final MessageBox box : this.getBoxes())
			if (box.getName().equals(name))
				return box;
		return result;
	}

}
