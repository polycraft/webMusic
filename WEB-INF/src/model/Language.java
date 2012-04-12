package model;

// Generated 12 avr. 2012 04:38:19 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Language generated by hbm2java
 */
public class Language implements java.io.Serializable {

	private Integer idLanguage;
	private String name;
	private Set<User> users = new HashSet<User>(0);

	public Language() {
	}

	public Language(String name) {
		this.name = name;
	}

	public Language(String name, Set<User> users) {
		this.name = name;
		this.users = users;
	}

	public Integer getIdLanguage() {
		return this.idLanguage;
	}

	public void setIdLanguage(Integer idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
