package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Destination;

@Service
public class MetierDestination implements IMetier<Destination> {
	@Autowired
	IDAO<Destination> daoDestination;

	@Override
	public boolean create(Destination o) {

		return daoDestination.save(o);
	}

	@Override
	public boolean update(Destination o) {

		return daoDestination.update(o);
	}

	@Override
	public boolean delete(Destination o) {

		return daoDestination.delete(o);
	}

	@Override
	public Destination findById(int id) {

		return daoDestination.findById(id);
	}

	@Override
	public List<Destination> findAll() {

		return daoDestination.findAll();
	}

	@Override
	public List<Destination> searchByType(String famille) {
		// TODO Auto-generated method stub
		return null;
	}

}
