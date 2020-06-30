package ma.pfe.projet.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.pfe.projet.entity.Client;
import ma.pfe.projet.metier.IMetier;

@ManagedBean
@Component
public class BeanClient {

	@Autowired
	IMetier<Client> metierClient;
	Client selectedClient = new Client();
	

	public Client getSelectedClient() {
		return selectedClient;
	}


	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}


	public List<Client> getListClients() {
		return metierClient.findAll();
	}
	public void delete() {
		FacesContext context = FacesContext.getCurrentInstance();
         
		if(metierClient.delete(selectedClient)) {
			context.addMessage(null, new FacesMessage("Successful",  "Client supprime avec succes"));
		}else {
			context.addMessage(null, new FacesMessage("Error",  "Erreur de suppression de la Client"));
		}
	}

}
