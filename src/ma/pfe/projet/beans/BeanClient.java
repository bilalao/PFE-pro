package ma.pfe.projet.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.pfe.projet.entity.Client;
import ma.pfe.projet.metier.IMetier;

@ManagedBean
@Component
public class BeanClient {

	@Autowired
	IMetier<Client> metierClient;
	Client newclient = new Client();
	Client selectedClient = new Client();
	

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public Client getnewclient() {
		return newclient;
	}

	public void setnewclient(Client newclient) {
		this.newclient = newclient;
	}
	
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierClient.save(newclient)) {
			context.addMessage(null, new FacesMessage("Successful",  "Client ajoute avec succes"));
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur d'ajout de Client"));
		}
		
		newclient.setName(""); 
		newclient.setAddress("");
		newclient.setEmail("");
		newclient.setPassword("");
		newclient.setPhone("");
		
	}
	
	public void delete() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierClient.delete(selectedClient)) {
			context.addMessage(null, new FacesMessage("Successful",  "Client supprime avec succes"));
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur de suppression de la Client"));
		}
	}
	
	public void update() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierClient.update(selectedClient)) {
			context.addMessage(null, new FacesMessage("Successful",  "Client modifie avec succes"));
			PrimeFaces.current().ajax().addCallbackParam("loggedIn", true);
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur de modification de la Client"));
			PrimeFaces.current().ajax().addCallbackParam("loggedIn", false);
		}
	}


	public List<Client> getListClients()
	{
		return metierClient.findAll();
		
	}
}
