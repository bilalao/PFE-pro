package ma.pfe.projet.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.pfe.projet.entity.Destination;
import ma.pfe.projet.metier.IMetier;

@ManagedBean
@Component
public class BeanDestination {
	@Autowired
	IMetier<Destination> metierDestination;
	
	public List<Destination> getListDestination() {
		return metierDestination.findAll();
	}

}
