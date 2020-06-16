package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Station;
@Service
public class MetierStation implements IMetier<Station> {
	@Autowired
	IDAO<Station> daostation;
	@Override
	public boolean create(Station o) {
		
		return daostation.save(o);
	}

	@Override
	public boolean update(Station o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Station o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Station findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Station> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Station> searchByType(String famille) {
		// TODO Auto-generated method stub
		return null;
	}

}
