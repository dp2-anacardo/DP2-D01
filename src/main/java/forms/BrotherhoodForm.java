
package forms;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import datatype.Url;
import domain.Area;
import domain.Brotherhood;

public class BrotherhoodForm {

	private String			confirmPass;
	private String			password;
	private String			username;
	private String			name;
	private String			photo;
	private String			email;
	private String			phoneNumber;
	private String			address;
	private int				id;
	private int				version;
	private String			title;
	private Collection<Url>	pictures;
	private Area			area;


	public BrotherhoodForm(final Brotherhood bro) {

		final BrotherhoodForm result = new BrotherhoodForm();
		result.setAddress(bro.getAddress());
		result.setEmail(bro.getEmail());
		result.setId(bro.getId());
		result.setName(bro.getName());
		result.setPhoneNumber(bro.getPhoneNumber());
		result.setPhoto(bro.getPhoto());
		result.setTitle(bro.getTitle());
		result.setPictures(bro.getPictures());
		result.setArea(bro.getArea());
		result.setVersion(bro.getVersion());
	}
	public BrotherhoodForm() {

	}

	@NotNull
	@NotBlank
	public String getConfirmPass() {
		return this.confirmPass;
	}

	public void setConfirmPass(final String confirmPass) {
		this.confirmPass = confirmPass;
	}

	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(final String photo) {
		this.photo = photo;
	}

	@NotBlank
	@Email
	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@NotBlank
	public String getPassword() {
		return this.password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}

	@NotBlank
	public String getUsername() {
		return this.username;
	}
	public void setUsername(final String username) {
		this.username = username;
	}

	@NotBlank
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	@NotEmpty
	@ElementCollection(fetch = FetchType.EAGER)
	@Valid
	public Collection<Url> getPictures() {
		return this.pictures;
	}

	public void setPictures(final Collection<Url> pictures) {
		this.pictures = pictures;
	}

	@Valid
	public Area getArea() {
		return this.area;
	}

	public void setArea(final Area area) {
		this.area = area;
	}

}
