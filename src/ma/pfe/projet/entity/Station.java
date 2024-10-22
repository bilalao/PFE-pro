package ma.pfe.projet.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "station")
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

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "destination_has_station", joinColumns = @JoinColumn(name = "station_idStation"), inverseJoinColumns = @JoinColumn(name = "destination_idDest"))
	private List<Destination> destinations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void addDestination(Destination theDestination) {
		if (destinations == null) {
			destinations = new ArrayList<>();
		}
		System.out.println("adding Destination into Station ....");
		destinations.add(theDestination);
		System.out.println("Done!");
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public int getIdStation() {
		return idStation;
	}

	public void setIdStation(int idStation) {
		this.idStation = idStation;
	}

	@Override
	public String toString() {
		return "Station [idStation=" + idStation + ", address=" + address + ", contact=" + contact + ", name=" + name
				+ ", destinations=" + destinations + "]";
	}

}
