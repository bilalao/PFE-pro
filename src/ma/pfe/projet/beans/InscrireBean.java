package ma.pfe.projet.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import ma.pfe.projet.dao.DaoClient;
import ma.pfe.projet.entity.Client;

import java.sql.Timestamp;
//import javax.ejb.EJB;

@ManagedBean
@RequestScoped
@Component
public class InscrireBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Client user;
// Injection de notre EJB (Session Bean Stateless)
	// @EJB
	private DaoClient utilisateurDao;

// Initialisation de l'entité utilisateur
	public InscrireBean() {
		user = new Client();
	}

// Méthode d'action appelée lors du clic sur le bouton du formulaire
// d'inscription
	public void inscrire() {
		initialiserDateInscription();
		utilisateurDao.save(user);
		FacesMessage message = new FacesMessage("Succès del'inscription !");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Client getUtilisateur() {
		return user;
	}

	private void initialiserDateInscription() {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		user.setDateInscription(date);
	}
}
