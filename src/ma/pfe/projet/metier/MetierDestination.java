package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pfe.projet.entity.Destination;

@Service
public class MetierDestination implements IMetier<Destination>{
	@Autowired
	

	@Override
	public boolean create(Destination o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Destination o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Destination o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Destination findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Destination> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Destination> searchByType(String famille) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
