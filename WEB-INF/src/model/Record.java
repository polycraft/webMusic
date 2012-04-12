package model;

// Generated 12 avr. 2012 14:23:42 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Record generated by hbm2java
 */
public class Record implements java.io.Serializable {

	private Integer idRecord;
	private Category category;
	private String title;
	private int width;
	private String matrix;
	private String pressInfo;
	private Set<User> users = new HashSet<User>(0);
	private Set<Track> tracks = new HashSet<Track>(0);
	private Set<Copy> copies = new HashSet<Copy>(0);
	private Set<LinkRecordPerson> linkRecordPersons = new HashSet<LinkRecordPerson>(
			0);

	public Record() {
	}

	public Record(Category category, String title, int width, String matrix,
			String pressInfo) {
		this.category = category;
		this.title = title;
		this.width = width;
		this.matrix = matrix;
		this.pressInfo = pressInfo;
	}

	public Record(Category category, String title, int width, String matrix,
			String pressInfo, Set<User> users, Set<Track> tracks,
			Set<Copy> copies, Set<LinkRecordPerson> linkRecordPersons) {
		this.category = category;
		this.title = title;
		this.width = width;
		this.matrix = matrix;
		this.pressInfo = pressInfo;
		this.users = users;
		this.tracks = tracks;
		this.copies = copies;
		this.linkRecordPersons = linkRecordPersons;
	}

	public Integer getIdRecord() {
		return this.idRecord;
	}

	public void setIdRecord(Integer idRecord) {
		this.idRecord = idRecord;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getMatrix() {
		return this.matrix;
	}

	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}

	public String getPressInfo() {
		return this.pressInfo;
	}

	public void setPressInfo(String pressInfo) {
		this.pressInfo = pressInfo;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Track> getTracks() {
		return this.tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	public Set<Copy> getCopies() {
		return this.copies;
	}

	public void setCopies(Set<Copy> copies) {
		this.copies = copies;
	}

	public Set<LinkRecordPerson> getLinkRecordPersons() {
		return this.linkRecordPersons;
	}

	public void setLinkRecordPersons(Set<LinkRecordPerson> linkRecordPersons) {
		this.linkRecordPersons = linkRecordPersons;
	}

}
