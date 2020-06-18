package ma.pfe.projet.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.pfe.projet.entity.Client;
import ma.pfe.projet.metier.IMetier;

@ManagedBean
@Component
public class BeanClient {

	@Autowired
	IMetier<Client> metierClient;
	
	public List<Client> getListClients()
	{
		return metierClient.findAll();
		
	}
}
