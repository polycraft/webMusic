package model;

// Generated 13 avr. 2012 18:31:48 by Hibernate Tools 3.4.0.CR1

/**
 * PlaylistWorker generated by hbm2java
 */
public class PlaylistWorker implements java.io.Serializable {

	private PlaylistWorkerId id;
	private Playlist playlist;
	private Right right;
	private User user;

	public PlaylistWorker() {
	}

	public PlaylistWorker(PlaylistWorkerId id, Playlist playlist, Right right,
			User user) {
		this.id = id;
		this.playlist = playlist;
		this.right = right;
		this.user = user;
	}

	public PlaylistWorkerId getId() {
		return this.id;
	}

	public void setId(PlaylistWorkerId id) {
		this.id = id;
	}

	public Playlist getPlaylist() {
		return this.playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Right getRight() {
		return this.right;
	}

	public void setRight(Right right) {
		this.right = right;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}