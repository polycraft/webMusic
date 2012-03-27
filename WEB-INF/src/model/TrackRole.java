package model;

// Generated 27 mars 2012 19:24:38 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * TrackRole generated by hbm2java
 */
public class TrackRole implements java.io.Serializable {

	private Integer idTrackRole;
	private String name;
	private Set<LinkTrackPerson> linkTrackPersons = new HashSet<LinkTrackPerson>(
			0);

	public TrackRole() {
	}

	public TrackRole(String name) {
		this.name = name;
	}

	public TrackRole(String name, Set<LinkTrackPerson> linkTrackPersons) {
		this.name = name;
		this.linkTrackPersons = linkTrackPersons;
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

	public Set<LinkTrackPerson> getLinkTrackPersons() {
		return this.linkTrackPersons;
	}

	public void setLinkTrackPersons(Set<LinkTrackPerson> linkTrackPersons) {
		this.linkTrackPersons = linkTrackPersons;
	}

}