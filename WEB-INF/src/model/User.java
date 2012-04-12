package model;

// Generated 12 avr. 2012 04:38:19 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer idUser;
	private Language language;
	private String username;
	private String password;
	private String emailAdress;
	private String firstname;
	private String lastname;
	private String biography;
	private String picture;
	private String website;
	private String socialNetworkAccount;
	private Set<Copy> copies = new HashSet<Copy>(0);

	public User() {
	}

	public User(Language language, String username, String password,
			String emailAdress, String firstname, String lastname,
			String biography, String picture, String website,
			String socialNetworkAccount) {
		this.language = language;
		this.username = username;
		this.password = password;
		this.emailAdress = emailAdress;
		this.firstname = firstname;
		this.lastname = lastname;
		this.biography = biography;
		this.picture = picture;
		this.website = website;
		this.socialNetworkAccount = socialNetworkAccount;
	}

	public User(Language language, String username, String password,
			String emailAdress, String firstname, String lastname,
			String biography, String picture, String website,
			String socialNetworkAccount, Set<Copy> copies) {
		this.language = language;
		this.username = username;
		this.password = password;
		this.emailAdress = emailAdress;
		this.firstname = firstname;
		this.lastname = lastname;
		this.biography = biography;
		this.picture = picture;
		this.website = website;
		this.socialNetworkAccount = socialNetworkAccount;
		this.copies = copies;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAdress() {
		return this.emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBiography() {
		return this.biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getSocialNetworkAccount() {
		return this.socialNetworkAccount;
	}

	public void setSocialNetworkAccount(String socialNetworkAccount) {
		this.socialNetworkAccount = socialNetworkAccount;
	}

	public Set<Copy> getCopies() {
		return this.copies;
	}

	public void setCopies(Set<Copy> copies) {
		this.copies = copies;
	}

}
