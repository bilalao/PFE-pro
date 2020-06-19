package ma.pfe.projet.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.pfe.projet.entity.Station;
import ma.pfe.projet.metier.IMetier;




@ManagedBean
@Component
public class BeanStation {
	@Autowired
	IMetier<Station> metierStation;
	
	Station sta = new Station();
	Station selectedStation = new Station();
	
	public Station getSelectedStation() {
		return selectedStation;
	}

	public void setSelectedStation(Station selectedStation) {
		this.selectedStation = selectedStation;
	}

	public Station getsta() {
		return sta;
	}

	public void setsta(Station sta) {
		this.sta = sta;
	}

	public List<Station> getListStations() {
		return metierStation.findAll();
	}
	
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierStation.save(sta)) {
			context.addMessage(null, new FacesMessage("Successful",  "Station ajoute avec succes"));
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur d'ajout de station"));
		}
		
		sta.setName(""); 
		sta.setaddress("");
		sta.setContact("");
	}
	
	public void delete() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierStation.delete(selectedStation)) {
			context.addMessage(null, new FacesMessage("Successful",  "Station supprime avec succes"));
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur de suppression de la station"));
		}
	}
	
	public void update() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierStation.update(selectedStation)) {
			context.addMessage(null, new FacesMessage("Successful",  "Station modifie avec succes"));
			PrimeFaces.current().ajax().addCallbackParam("loggedIn", true);
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur de modification de la station"));
			PrimeFaces.current().ajax().addCallbackParam("loggedIn", false);
		}
	}
}
