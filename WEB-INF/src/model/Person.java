package model;

// Generated 13 avr. 2012 18:31:48 by Hibernate Tools 3.4.0.CR1

/**
 * Person generated by hbm2java
 */
public class Person implements java.io.Serializable {

	private Integer idPerson;
	private Track track;
	private TrackRole trackRole;
	private String name;

	public Person() {
	}

	public Person(Track track, TrackRole trackRole, String name) {
		this.track = track;
		this.trackRole = trackRole;
		this.name = name;
	}

	public Integer getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public TrackRole getTrackRole() {
		return this.trackRole;
	}

	public void setTrackRole(TrackRole trackRole) {
		this.trackRole = trackRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
