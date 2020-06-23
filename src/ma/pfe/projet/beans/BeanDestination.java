package ma.pfe.projet.beans;

//import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.pfe.projet.entity.Destination;
import ma.pfe.projet.metier.IMetier;

@ManagedBean
@Component
public class BeanDestination {

	@Autowired
	IMetier<Destination> metierDestination;
	//Destination newDest = new Destination();

	//private List<Bus> busList;

	//IMetier<Bus> metierBus;

	private String city;
	private String Bus;
	private Map<String, String> cities = new HashMap<String, String>();
	private Map<String, String> buss = new HashMap<String, String>();

	@PostConstruct
	public void init() {

		// cities
		cities = new HashMap<String, String>();
		cities.put("New York", "New York");
		cities.put("London", "London");
		cities.put("Paris", "Paris");
		cities.put("Barcelona", "Barcelona");
		cities.put("Istanbul", "Istanbul");
		cities.put("Berlin", "Berlin");

		// buss
		buss = new HashMap<String, String>();
		buss.put("Bus1", "Bus1");
		buss.put("Bus2", "Bus2");
		buss.put("Bus3", "Bus3");
		buss.put("Bus4", "Bus4");
		buss.put("Bus5", "Bus5");
		buss.put("Bus6", "Bus6");

		//this.busList = metierBus.findAll();

	}

/*
	public Destination getnewDest() {
		return newDest;
	}

	public void setnewDest(Destination newDest) {
		this.newDest = newDest;
	}
*/
	public String getBus() {
		return Bus;
	}

	public void setBus(String bus) {
		Bus = bus;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public Map<String, String> getBuss() {
		return buss;
	}

/*
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (metierDestination.save(newDest)) {
			context.addMessage(null, new FacesMessage("Successful", "Bus ajoute avec succes"));
		} else {
			context.addMessage(null, new FacesMessage("Error", "Erreur d'ajout de Bus"));
		}
		
		
		//newDest.setTotal_seat(0);
		//newDest.setFare("");
		 
	}
*/
}
