package model;

// Generated 8 avr. 2012 19:54:58 by Hibernate Tools 3.4.0.CR1

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
	private Set<Track> tracks = new HashSet<Track>(0);
	private Set<LinkRecordPerson> linkRecordPersons = new HashSet<LinkRecordPerson>(
			0);
	private Set<Copy> copies = new HashSet<Copy>(0);

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
			String pressInfo, Set<Track> tracks,
			Set<LinkRecordPerson> linkRecordPersons, Set<Copy> copies) {
		this.category = category;
		this.title = title;
		this.width = width;
		this.matrix = matrix;
		this.pressInfo = pressInfo;
		this.tracks = tracks;
		this.linkRecordPersons = linkRecordPersons;
		this.copies = copies;
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

	public Set<Track> getTracks() {
		return this.tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	public Set<LinkRecordPerson> getLinkRecordPersons() {
		return this.linkRecordPersons;
	}

	public void setLinkRecordPersons(Set<LinkRecordPerson> linkRecordPersons) {
		this.linkRecordPersons = linkRecordPersons;
	}

	public Set<Copy> getCopies() {
		return this.copies;
	}

	public void setCopies(Set<Copy> copies) {
		this.copies = copies;
	}

}
