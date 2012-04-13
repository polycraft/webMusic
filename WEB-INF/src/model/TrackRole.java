package model;

// Generated 13 avr. 2012 15:26:32 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * TrackRole generated by hbm2java
 */
public class TrackRole implements java.io.Serializable {

	private Integer idTrackRole;
	private String name;
	private Set<Person> persons = new HashSet<Person>(0);

	public TrackRole() {
	}

	public TrackRole(String name) {
		this.name = name;
	}

	public TrackRole(String name, Set<Person> persons) {
		this.name = name;
		this.persons = persons;
	}

	public Integer getIdTrackRole() {
		return this.idTrackRole;
	}

	public void setIdTrackRole(Integer idTrackRole) {
		this.idTrackRole = idTrackRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

}
