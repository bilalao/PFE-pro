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
	public boolean save(Destination o) {
		// TODO Auto-generated method stub
		return daoDestination.save(o);
	}

	@Override
	public boolean update(Destination o) {
		// TODO Auto-generated method stub
		return daoDestination.update(o);
	}

	@Override
	public boolean delete(Destination o) {
		// TODO Auto-generated method stub
		return daoDestination.delete(o);
	}

	@Override
	public Destination findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Destination> findAll() {
		// TODO Auto-generated method stub
		return daoDestination.findAll();
	}

	@Override
	public boolean validate(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
