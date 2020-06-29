package ma.pfe.projet.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.pfe.projet.entity.Bus;
import ma.pfe.projet.entity.Destination;
import ma.pfe.projet.entity.Station;
import ma.pfe.projet.metier.IMetier;
import ma.pfe.projet.metier.MetierBus;
import ma.pfe.projet.metier.MetierStation;

@ManagedBean
@Component
public class BeanDestination {

	@Autowired
	IMetier<Destination> metierDestination;

	Destination newDest = new Destination();
	Destination selectedDest = new Destination();

	@Autowired
	MetierBus metierBus;
	Bus bus;
	@Autowired
	MetierStation metierStation;

	private int busId;
	private int stationFromId;
	private int stationToId;

	@PostConstruct
	public void init() {
	}

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

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public Destination getnewDest() {
		return newDest;
	}

	public void setnewDest(Destination newDest) {
		this.newDest = newDest;
	}

	public List<Station> getListStation() {
		return metierStation.findAll();
	}

	public List<Bus> getListBus() {
		return metierBus.findAll();
	}

	public List<Destination> getListDestination() {
		return metierDestination.findAll();
	}

	public Destination getSelectedDest() {
		return selectedDest;
	}

	public void setSelectedDest(Destination selectedDest) {
		this.selectedDest = selectedDest;
	}

	public void save() {
		// get bus and stations Ids
		Bus bus = metierBus.findById(busId);
		Station st_to = metierStation.findById(stationToId);
		Station st_from = metierStation.findById(stationFromId);

		// add fields to Destination
		newDest.setTotal_seat(bus.getTotal_seat());
		newDest.setStation_from(st_from.getName());
		newDest.setStation_to(st_to.getName());

		// test
		System.out.println("st_from::" + st_from.getName());
		System.out.println("st_to::" + st_to.getName());
		System.out.println("Total seat:" + bus.getTotal_seat());
		FacesContext context = FacesContext.getCurrentInstance();
		
		////add bus to destination
		List<Bus> addedbus = new ArrayList<>();
		addedbus.add(bus);
		newDest.setBus(addedbus);
		// add stat_from and stat_to  To dest
		List<Station> addedStations = new ArrayList<>();
		addedStations.add(st_to);
		
		addedStations.add(st_from);
		newDest.setStations(addedStations);
	
		if (metierDestination.save(newDest)) {
			System.out.println("id of new Destination ="+newDest.getIdDest());
			context.addMessage(null, new FacesMessage("Successful", "Destination ajoute avec succes"));
		} else {
			context.addMessage(null, new FacesMessage("Error", "Erreur d'ajout de Destination"));
		}

		newDest.setFare(0);
		newDest.setTime(0);

	}
	public void delete() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierDestination.delete(selectedDest)) {
			context.addMessage(null, new FacesMessage("Successful",  "Destination supprime avec succes"));
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur de suppression de la Destination"));
		}
	}
}
