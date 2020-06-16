package ma.pfe.projet.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.pfe.projet.entity.Reservation;
import ma.pfe.projet.metier.IMetier;

@ManagedBean
@Component
public class BeanReservation {
	@Autowired
	IMetier<Reservation> metierReservation;
	public List<Reservation> getListReservation(){
		return metierReservation.findAll();
	}

}
