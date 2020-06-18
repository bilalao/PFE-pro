package ma.pfe.projet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBus")
	private int idBus;
	@Column(name = "total_seat")
	private int total_seat;
	@Column(name = "matricule")
	private String matricule;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy="bus", 
			cascade={CascadeType.DETACH, CascadeType.MERGE,
					 CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Destination> destinations;
	
	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public int getIdBus() {
		return idBus;
	}

	public void setIdBus(int idBus) {
		this.idBus = idBus;
	}

	public int getTotal_seat() {
		return total_seat;
	}

	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String code) {
		this.matricule = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Bus(int total_seat, String matricule, String name, String type) {
		this.total_seat = total_seat;
		this.matricule = matricule;
		this.name = name;
		this.type = type;
	}
	
	public Bus() {
		super();
	}
	

	@Override
	public String toString() {
		return "Bus [idBus=" + idBus + ", total_seat=" + total_seat + ", matricule=" + matricule + ", name=" + name
				+ ", type=" + type + "]";
	}
	

}
