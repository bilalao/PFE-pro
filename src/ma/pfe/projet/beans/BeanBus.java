package ma.pfe.projet.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.pfe.projet.entity.Bus;

import ma.pfe.projet.metier.IMetier;

@ManagedBean
@Component
public class BeanBus {
	@Autowired
	IMetier<Bus> metierBus;
	
	Bus newbus = new Bus();
	Bus selectedBus = new Bus();
	
	

	public Bus getSelectedBus() {
		return selectedBus;
	}

	public void setSelectedBus(Bus selectedBus) {
		this.selectedBus = selectedBus;
	}

	public Bus getnewbus() {
		return newbus;
	}

	public void setnewbus(Bus newbus) {
		this.newbus = newbus;
	}
	
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierBus.save(newbus)) {
			context.addMessage(null, new FacesMessage("Successful",  "Bus ajoute avec succes"));
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur d'ajout de Bus"));
		}
		
		newbus.setName(""); 
		newbus.setMatricule("");
		newbus.setTotal_seat(0);
		newbus.setType("");
	}
	
	public void delete() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierBus.delete(selectedBus)) {
			context.addMessage(null, new FacesMessage("Successful",  "Bus supprime avec succes"));
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur de suppression de la Bus"));
		}
	}
	
	public void update() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierBus.update(selectedBus)) {
			context.addMessage(null, new FacesMessage("Successful",  "Bus modifie avec succes"));
			PrimeFaces.current().ajax().addCallbackParam("loggedIn", true);
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur de modification de la Bus"));
			PrimeFaces.current().ajax().addCallbackParam("loggedIn", false);
		}
	}



	public List<Bus> getListBus() {
		return metierBus.findAll();
	}
}
