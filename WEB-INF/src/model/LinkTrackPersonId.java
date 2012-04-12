package model;

// Generated 12 avr. 2012 06:12:49 by Hibernate Tools 3.4.0.CR1

/**
 * LinkTrackPersonId generated by hbm2java
 */
public class LinkTrackPersonId implements java.io.Serializable {

	private int idTrack;
	private int idPerson;
	private int idTrackRole;

	public LinkTrackPersonId() {
	}

	public LinkTrackPersonId(int idTrack, int idPerson, int idTrackRole) {
		this.idTrack = idTrack;
		this.idPerson = idPerson;
		this.idTrackRole = idTrackRole;
	}

	public int getIdTrack() {
		return this.idTrack;
	}

	public void setIdTrack(int idTrack) {
		this.idTrack = idTrack;
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public int getIdTrackRole() {
		return this.idTrackRole;
	}

	public void setIdTrackRole(int idTrackRole) {
		this.idTrackRole = idTrackRole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LinkTrackPersonId))
			return false;
		LinkTrackPersonId castOther = (LinkTrackPersonId) other;

		return (this.getIdTrack() == castOther.getIdTrack())
				&& (this.getIdPerson() == castOther.getIdPerson())
				&& (this.getIdTrackRole() == castOther.getIdTrackRole());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdTrack();
		result = 37 * result + this.getIdPerson();
		result = 37 * result + this.getIdTrackRole();
		return result;
	}

}
