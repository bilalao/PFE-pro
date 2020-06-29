package ma.pfe.projet.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.pfe.projet.entity.Client;
import ma.pfe.projet.entity.Destination;
import ma.pfe.projet.entity.Reservation;
import ma.pfe.projet.metier.IMetier;
import ma.pfe.projet.metier.MetierDestination;

@ManagedBean
@Component
public class BeanReservation {
	@Autowired
	IMetier<Reservation> metierReservation;
	Reservation newRes = new Reservation();
	
	@Autowired
	MetierDestination metierDestination;
	
	@Autowired
	IMetier<Client> metierClient;
	Client newclient = new Client();
	
	private int stationFromId;
	private int stationToId;
	
	private List<String> listFrom = new ArrayList<>();
	
	private String destFrom;
	
	private List<String> listTo = new ArrayList<>();
	
	private String destTo;
	
	private List<Integer> listJourney_date = new ArrayList<>();
	
	private Integer selectedJourney_date;

	public int getStationFromId() {
		return stationFromId;
	}

	public void setStationFromId(int stationFromId) {
		this.stationFromId = stationFromId;
	}

	public int getStationToId() {
		return stationToId;
	}

	public void setStationToId(int stationToId) {
		this.stationToId = stationToId;
	}

	public Reservation getNewRes() {
		return newRes;
	}

	public void setNewRes(Reservation newRes) {
		this.newRes = newRes;
	}

	

	public List<Reservation> getListReservations() {
		return metierReservation.findAll();
	}

	public List<Destination> getListDestinations() {
		return metierDestination.findAll();
	}
	
	
	public List<String> getListFrom() {
		this.listFrom = new ArrayList<>();
		for(Destination dest : this.getListDestinations()) {
			if(!listFrom.contains(dest.getStation_from())) {
				listFrom.add(dest.getStation_from());
			}
		}
		return listFrom;
	}

	public void setListFrom(List<String> listFrom) {
		this.listFrom = listFrom;
	}

	
	public String getDestFrom() {
		return destFrom;
	}

	public void setDestFrom(String destFrom) {
		this.destFrom = destFrom;
	}

	
	public List<String> getListTo() {
		listTo = new ArrayList<>();
		if(null == destFrom || "".equals(destFrom)) {
			return new ArrayList<>();
		}
		List<Destination> resultDestFrom = metierDestination.findByDestFrom(destFrom);
		for(Destination dest : resultDestFrom) {
			System.out.println("---------_______  "+dest.getStation_to());
			if(!listTo.contains(dest.getStation_to())) {
				listTo.add(dest.getStation_to());
			}
		}
		
		return listTo;
	}

	public void setListTo(List<String> listTo) {
		this.listTo = listTo;
	}

	public String getDestTo() {
		return destTo;
	}

	public void setDestTo(String destTo) {
		this.destTo = destTo;
	}

	public void fromWasSelected() {
		System.out.println("--------------- "+destFrom);
		this.getListTo();
	}
	
	public void toWasSelected() {
		System.out.println("--------------- "+destFrom);
		this.getListJourney_date();
	} 
	
	public List<Integer> getListJourney_date() {
		listJourney_date = new ArrayList<>();
		if(null == destFrom || "".equals(destFrom ) || null == destTo || "".equals(destTo)) {
			return new ArrayList<>();
		}
		List<Destination> resultDestFromAndTo = metierDestination.findByDestFromAndDestTo(destFrom, destTo);
		for(Destination dest : resultDestFromAndTo) {
			System.out.println("---------_______  "+dest.getTime());
			if(!listJourney_date.contains(dest.getTime())) {
				listJourney_date.add(dest.getTime());
			}
		}
		return listJourney_date;
	}

	public void setListJourney_date(List<Integer> listJourney_date) {
		this.listJourney_date = listJourney_date;
	}

	public Integer getSelectedJourney_date() {
		return selectedJourney_date;
	}

	public void setSelectedJourney_date(Integer selectedJourney_date) {
		this.selectedJourney_date = selectedJourney_date;
	}

	public void save() {
		System.out.println("(------------------------- date  "+selectedJourney_date);
		FacesContext context = FacesContext.getCurrentInstance();
		List<Destination>  resultListDest = metierDestination.findByDestFromAndDestToAndDate(destFrom, destTo, selectedJourney_date);
		Destination destToSave = resultListDest.get(0);
		System.out.println("(------------------------- statstion from  "+destToSave.getStation_from());
		System.out.println("n");
		//newRes.setBus(destToSave.getBus().get(0));
		newRes.setSeat_numbers(destToSave.getTotal_seat());
		newRes.setJourney_date(destToSave.getTime());
		System.out.println(new Date());
		//newRes.setBooking_date(new Date ());
		newRes.setBooking_date(10);
		Integer totalNumberOfSeats = destToSave.getTotal_seat() + 1;
		Integer seatNumber = 1;
		System.out.println("a");
		if(null != destToSave.getReservations() && destToSave.getReservations().size() > 0) {
			seatNumber = destToSave.getReservations().size() + 1;
		}
		System.out.println("(------------------------- dest bus  "+destToSave.getBus().get(0).getMatricule());
		
		newRes.setBus(destToSave.getBus().get(0));
		
		if(seatNumber > totalNumberOfSeats) {
			context.addMessage(null, new FacesMessage("Error",  "the bus is full"));
		}
		System.out.println("b");
		newRes.setNumber_of_seat(seatNumber);
		
		 if(metierClient.save(newclient)) {

		  System.out.println(" ID CLIENT : "+newclient.getNumcli());
		 }
		//List < Client> listClient = metierClient.findAll();
        newRes.setClient(newclient);
        List <Destination>  resDest = new ArrayList<>();
        resDest.add(destToSave);
        newRes.setDestinations(resDest);
        if(metierReservation.save(newRes)) {
			context.addMessage(null, new FacesMessage("Successful", "Merci !!"));
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur de reserver"));
		}
		
		
		
		
		newclient.setName(""); 
		newclient.setAddress("");
		newclient.setEmail("");
	
		newclient.setPhone("");
		//newRes.setName(""); 
	
	}
	
	public Client getnewclient() {
		return newclient;
	}

	public void setnewclient(Client newclient) {
		this.newclient = newclient;
	}
	
	
}
