package model;

// Generated 12 avr. 2012 04:38:19 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Person generated by hbm2java
 */
public class Person implements java.io.Serializable {

	private int idPerson;
	private String name;
	private Date birthname;
	private Set<LinkRecordPerson> linkRecordPersons = new HashSet<LinkRecordPerson>(
			0);
	private Set<LinkTrackPerson> linkTrackPersons = new HashSet<LinkTrackPerson>(
			0);

	public Person() {
	}

	public Person(int idPerson, String name, Date birthname) {
		this.idPerson = idPerson;
		this.name = name;
		this.birthname = birthname;
	}

	public Person(int idPerson, String name, Date birthname,
			Set<LinkRecordPerson> linkRecordPersons,
			Set<LinkTrackPerson> linkTrackPersons) {
		this.idPerson = idPerson;
		this.name = name;
		this.birthname = birthname;
		this.linkRecordPersons = linkRecordPersons;
		this.linkTrackPersons = linkTrackPersons;
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthname() {
		return this.birthname;
	}

	public void setBirthname(Date birthname) {
		this.birthname = birthname;
	}

	public Set<LinkRecordPerson> getLinkRecordPersons() {
		return this.linkRecordPersons;
	}

	public void setLinkRecordPersons(Set<LinkRecordPerson> linkRecordPersons) {
		this.linkRecordPersons = linkRecordPersons;
	}

	public Set<LinkTrackPerson> getLinkTrackPersons() {
		return this.linkTrackPersons;
	}

	public void setLinkTrackPersons(Set<LinkTrackPerson> linkTrackPersons) {
		this.linkTrackPersons = linkTrackPersons;
	}

}
