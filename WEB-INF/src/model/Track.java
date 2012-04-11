package model;

// Generated 8 avr. 2012 19:54:58 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Track generated by hbm2java
 */
public class Track implements java.io.Serializable {

	private Integer idTrack;
	private Style style;
	private String title;
	private String rythm;
	private int label;
	private int playingTime;
	private Date releaseDate;
	private Set<Record> records = new HashSet<Record>(0);
	private Set<LinkTrackPerson> linkTrackPersons = new HashSet<LinkTrackPerson>(
			0);

	public Track() {
	}

	public Track(Style style, String title, String rythm, int label,
			int playingTime, Date releaseDate) {
		this.style = style;
		this.title = title;
		this.rythm = rythm;
		this.label = label;
		this.playingTime = playingTime;
		this.releaseDate = releaseDate;
	}

	public Track(Style style, String title, String rythm, int label,
			int playingTime, Date releaseDate, Set<Record> records,
			Set<LinkTrackPerson> linkTrackPersons) {
		this.style = style;
		this.title = title;
		this.rythm = rythm;
		this.label = label;
		this.playingTime = playingTime;
		this.releaseDate = releaseDate;
		this.records = records;
		this.linkTrackPersons = linkTrackPersons;
	}

	public Integer getIdTrack() {
		return this.idTrack;
	}

	public void setIdTrack(Integer idTrack) {
		this.idTrack = idTrack;
	}

	public Style getStyle() {
		return this.style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRythm() {
		return this.rythm;
	}

	public void setRythm(String rythm) {
		this.rythm = rythm;
	}

	public int getLabel() {
		return this.label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public int getPlayingTime() {
		return this.playingTime;
	}

	public void setPlayingTime(int playingTime) {
		this.playingTime = playingTime;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Set<Record> getRecords() {
		return this.records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}

	public Set<LinkTrackPerson> getLinkTrackPersons() {
		return this.linkTrackPersons;
	}

	public void setLinkTrackPersons(Set<LinkTrackPerson> linkTrackPersons) {
		this.linkTrackPersons = linkTrackPersons;
	}

}
