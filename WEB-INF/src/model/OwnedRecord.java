package model;

// Generated 12 avr. 2012 03:43:20 by Hibernate Tools 3.4.0.CR1

/**
 * OwnedRecord generated by hbm2java
 */
public class OwnedRecord implements java.io.Serializable {

	private Integer idOwnedRecord;
	private int idUser;
	private int name;

	public OwnedRecord() {
	}

	public OwnedRecord(int idUser, int name) {
		this.idUser = idUser;
		this.name = name;
	}

	public Integer getIdOwnedRecord() {
		return this.idOwnedRecord;
	}

	public void setIdOwnedRecord(Integer idOwnedRecord) {
		this.idOwnedRecord = idOwnedRecord;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getName() {
		return this.name;
	}

	public void setName(int name) {
		this.name = name;
	}

}