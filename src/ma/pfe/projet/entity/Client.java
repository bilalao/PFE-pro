package ma.pfe.projet.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numcli")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int numcli;

	@Column(name="address")
	private String address;

	@Column(name="email")
	private String email;

	@Column(name="name")
	private String name;

	@Column(name="password")
	private String password;
	
	@Column(name="phone")
	private String phone;
	
	@Column( name = "date_inscription" )
	private Timestamp dateInscription;
	
	 @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	 private List<Reservation> reservations;
	

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public int getNumcli() {
		return numcli;
	}

	public void setNumcli(int numcli) {
		this.numcli = numcli;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Client(int numcli, String address, String email, String name, String password, String phone) {
		super();
		this.numcli = numcli;
		this.address = address;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client [numcli=" + numcli + ", address=" + address + ", email=" + email + ", name=" + name
				+ ", password=" + password + ", phone=" + phone + "]";
	}

	public Timestamp getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Timestamp dateInscription) {
		this.dateInscription = dateInscription;
	}
	

	


	

	
	/*
	 * public List<Commande> getCommandes() { return commandes; } public void
	 * setCommandes(List<Commande> commandes) { this.commandes = commandes; }
	 */
}
