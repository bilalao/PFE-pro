package ma.pfe.projet.entity;

import java.io.Serializable;

import java.util.List;

import java.util.Date;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReservation;
	@Column
	private int seat_numbers;
	@Column
	private int number_of_seat;
	@Column
	private int journey_date;
	@Column
	private Date booking_date;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH ,CascadeType.REMOVE})
	@JoinColumn(name = "client_numcli")
	private Client client;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "bus_idBus")
	private Bus bus;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "reservation_has_destination",
			joinColumns = @JoinColumn(name = "reservation_idReservation"),
			inverseJoinColumns = @JoinColumn(name = "destination_idDest"))
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Destination> destinations;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public int getJourney_date() {
		return journey_date;
	}

	public void setJourney_date(int journey_date) {
		this.journey_date = journey_date;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public int getSeat_numbers() {
		return seat_numbers;
	}

	public void setSeat_numbers(int seat_numbers) {
		this.seat_numbers = seat_numbers;
	}

	public int getNumber_of_seat() {
		return number_of_seat;
	}

	public void setNumber_of_seat(int number_of_seat) {
		this.number_of_seat = number_of_seat;
	}

	public Reservation() {
		super();
	}

	public Reservation(int seat_numbers, int number_of_seat, int journey_date, Date booking_date) {
		super();
		this.seat_numbers = seat_numbers;
		this.number_of_seat = number_of_seat;
		this.journey_date = journey_date;
		this.booking_date = booking_date;
	}

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", seat_numbers=" + seat_numbers + ", number_of_seat="
				+ number_of_seat + ", journey_date=" + journey_date + ", booking_date=" + booking_date + ", client="
				+ client + ", bus=" + bus + ", destinations=" + destinations + "]";
	}

}
