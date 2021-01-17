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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "destination")
public class Destination implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDest")
	private int idDest;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "destination_has_station", joinColumns = @JoinColumn(name = "destination_idDest"), inverseJoinColumns = @JoinColumn(name = "station_idStation"))
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @Fetch(value= FetchMode.SUBSELECT)
	private List<Station> stations;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "destination_has_bus", joinColumns = @JoinColumn(name = "destination_idDest"), inverseJoinColumns = @JoinColumn(name = "bus_idBus"))
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @Fetch(value= FetchMode.SUBSELECT)
	private List<Bus> bus;
	@Column
	private String station_from;
	@Column
	private String station_to;
	@Column
	private int time;
	@Column
	private double fare;
	@Column
	private int total_seat;

	@ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	@JoinTable(name = "reservation_has_destination",
	joinColumns = @JoinColumn(name = "destination_idDest"),
	inverseJoinColumns = @JoinColumn(name = "reservation_idReservation"))
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @Fetch(value= FetchMode.SUBSELECT)
	private List<Reservation> reservations;

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getStation_from() {
		return station_from;
	}

	public void setStation_from(String station_from) {
		this.station_from = station_from;
	}

	public String getStation_to() {
		return station_to;
	}

	public void setStation_to(String station_to) {
		this.station_to = station_to;
	}

	public int getIdDest() {
		return idDest;
	}

	public void setIdDest(int idDest) {
		this.idDest = idDest;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}



	

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public int getTotal_seat() {
		return total_seat;
	}

	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}

	public Destination(int time, double fare, int total_seat) {
		this.time = time;

		this.fare = fare;

	}

	public Destination(String station_from, String station_to, int time, double fare, int total_seat) {
		super();
		this.station_from = station_from;
		this.station_to = station_to;
		this.time = time;
		this.fare = fare;
		this.total_seat = total_seat;
	}

	public Destination() {
		super();
	}

	/*
	public void addStation(Station theStation) {
		if (stations == null) {
			stations = new ArrayList<>();
		}
		System.out.println("adding Station into destination ....");
		stations.add(theStation);
		System.out.println("Done!");
	}

	public void addBus(Bus theBus) {
		if (bus == null) {
			bus = new ArrayList<>();
		}
		System.out.println("adding bus into destination ....");
		bus.add(theBus);
		System.out.println("Done!");
	}
*/
	@Override
	public String toString() {
		return "Destination [idDest=" + idDest + ", stations=" + stations + ", bus=" + bus + ", station_from="
				+ station_from + ", station_to=" + station_to + ", time=" + time + ", fare=" + fare + ", total_seat="
				+ total_seat + ", reservations=" + reservations + "]";
	}

}
