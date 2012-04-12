package model;

// Generated 12 avr. 2012 06:12:49 by Hibernate Tools 3.4.0.CR1

/**
 * LinkTrackPerson generated by hbm2java
 */
public class LinkTrackPerson implements java.io.Serializable {

	private LinkTrackPersonId id;
	private Track track;
	private Person person;
	private TrackRole trackRole;

	public LinkTrackPerson() {
	}

	public LinkTrackPerson(LinkTrackPersonId id, Track track, Person person,
			TrackRole trackRole) {
		this.id = id;
		this.track = track;
		this.person = person;
		this.trackRole = trackRole;
	}

	public LinkTrackPersonId getId() {
		return this.id;
	}

	public void setId(LinkTrackPersonId id) {
		this.id = id;
	}

	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public TrackRole getTrackRole() {
		return this.trackRole;
	}

	public void setTrackRole(TrackRole trackRole) {
		this.trackRole = trackRole;
	}

}
