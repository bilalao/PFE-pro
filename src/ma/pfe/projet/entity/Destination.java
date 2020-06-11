package ma.pfe.projet.entity;

import java.io.Serializable;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="destinations")
public class Destination implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDest")
	private int idDest;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="stations_id")
	private Station station; 

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						CascadeType.DETACH,  CascadeType.REFRESH})
	@JoinColumn(name = "bus_id")
	private Bus bus;
	
	@Column
	private int time;
	@Column
	private String status;
	@Column
	private String fare;
	@Column
	private int last_activity;
	@Column
	private int total_seat;
	@Column
	private String type;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					  CascadeType.DETACH,  CascadeType.REFRESH})
	@JoinTable(
			name="reservations_has_destinations",
			joinColumns=@JoinColumn(name="destinations_id"),
			inverseJoinColumns=@JoinColumn(name="reservations_id")
			)
	private List<Reservation> reservations;
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public int getIdDest() {
		return idDest;
	}
	public void setIdDest(int idDest) {
		this.idDest = idDest;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public int getLast_activity() {
		return last_activity;
	}
	public void setLast_activity(int last_activity) {
		this.last_activity = last_activity;
	}
	public int getTotal_seat() {
		return total_seat;
	}
	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Destination(int time, String status, String fare, int last_activity,
			int total_seat, String type) {
		this.time = time;
		this.status = status;
		this.fare = fare;
		this.last_activity = last_activity;
		this.total_seat = total_seat;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Destination [idDest=" + idDest + ", time=" + time + ", status=" + status + ", fare=" + fare
				+ ", last_activity=" + last_activity + ", total_seat=" + total_seat + ", type=" + type
				+ ", reservations=" + reservations + "]";
	}
	
	
	

}
