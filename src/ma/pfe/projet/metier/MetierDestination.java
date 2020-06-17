package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Destination;

@Service
public class MetierDestination implements IMetier<Destination> {
	@Autowired
	IDAO<Destination> daodestination;

	@Override
	public boolean create(Destination o) {

		return daodestination.save(o);
	}

	@Override
	public boolean update(Destination o) {

		return daodestination.update(o);
	}

	@Override
	public boolean delete(Destination o) {

		return daodestination.delete(o);
	}

	@Override
	public Destination findById(int id) {

		return daodestination.findById(id);
	}

	@Override
	public List<Destination> findAll() {

		return daodestination.findAll();
	}

	@Override
	public List<Destination> searchByType(String famille) {
		// TODO Auto-generated method stub
		return null;
	}

}
