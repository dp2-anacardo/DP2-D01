
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends DomainEntity {

	private String	name;
	private String	middleName;
	private String	surname;
	private String	photo;
	private String	email;
	private String	phoneNumber;
	private String	address;


	@NotBlank
	public String getName() {
		return this.name;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	@NotBlank
	public String getSurname() {
		return this.surname;
	}

	@URL
	public String getPhoto() {
		return this.photo;
	}

	@NotBlank
	@Email
	public String getEmail() {
		return this.email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
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

}
