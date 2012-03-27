package model;

// Generated 27 mars 2012 19:24:38 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * RecordRole generated by hbm2java
 */
public class RecordRole implements java.io.Serializable {

	private int idRecordRole;
	private String name;
	private Set<LinkRecordPerson> linkRecordPersons = new HashSet<LinkRecordPerson>(
			0);

	public RecordRole() {
	}

	public RecordRole(int idRecordRole, String name) {
		this.idRecordRole = idRecordRole;
		this.name = name;
	}

	public RecordRole(int idRecordRole, String name,
			Set<LinkRecordPerson> linkRecordPersons) {
		this.idRecordRole = idRecordRole;
		this.name = name;
		this.linkRecordPersons = linkRecordPersons;
	}

	public int getIdRecordRole() {
		return this.idRecordRole;
	}

	public void setIdRecordRole(int idRecordRole) {
		this.idRecordRole = idRecordRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<LinkRecordPerson> getLinkRecordPersons() {
		return this.linkRecordPersons;
	}

	public void setLinkRecordPersons(Set<LinkRecordPerson> linkRecordPersons) {
		this.linkRecordPersons = linkRecordPersons;
	}

}