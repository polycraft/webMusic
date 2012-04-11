package model;

// Generated 8 avr. 2012 19:54:58 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Style generated by hbm2java
 */
public class Style implements java.io.Serializable {

	private Integer idStyle;
	private String name;
	private Set<Track> tracks = new HashSet<Track>(0);

	public Style() {
	}

	public Style(String name) {
		this.name = name;
	}

	public Style(String name, Set<Track> tracks) {
		this.name = name;
		this.tracks = tracks;
	}

	public Integer getIdStyle() {
		return this.idStyle;
	}

	public void setIdStyle(Integer idStyle) {
		this.idStyle = idStyle;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Track> getTracks() {
		return this.tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

}
