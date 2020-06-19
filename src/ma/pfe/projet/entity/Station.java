package ma.pfe.projet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stations")
public class Station implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStation")
	private int idStation;
	@Column(name = "address")
	private String address;
	@Column(name = "contact")
	private String contact;
	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getidStation() {
		return idStation;
	}

	public void setidStation(int idStation) {
		this.idStation = idStation;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Station(int idStation, String address, String contact, String name) {
		super();
		this.idStation = idStation;
		this.address = address;
		this.contact = contact;
		this.name = name;
	}

	public Station() {
		super();
	}

}
