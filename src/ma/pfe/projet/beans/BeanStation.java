package ma.pfe.projet.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.pfe.projet.entity.Station;
import ma.pfe.projet.metier.IMetier;

@ManagedBean
@Component
public class BeanStation {
	@Autowired
	IMetier<Station> metierStation;
	public List<Station> getListStation(){
		return metierStation.findAll();
	}
	

}
