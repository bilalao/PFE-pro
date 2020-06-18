package ma.pfe.projet.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.pfe.projet.entity.Bus;
import ma.pfe.projet.metier.IMetier;


@ManagedBean
@Component
public class BeanBus {
@Autowired
	IMetier<Bus> metierBus;

public List<Bus> getListBus()
{
	return metierBus.findAll();
}
}
