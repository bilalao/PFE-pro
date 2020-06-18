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
	public boolean save(Station o) {
		
		return daostation.save(o);
	}

	@Override
	public boolean update(Station o) {
		
		return daostation.update(o);
	}

	@Override
	public boolean delete(Station o) {
	
		return daostation.delete(o);
	}

	@Override
	public Station findById(int id) {
		
		return daostation.findById(id);
	}

	@Override
	public List<Station> findAll() {
	
		return daostation.findAll();
	}

	@Override
	public List<Station> searchByType(String famille) {
		// TODO Auto-generated method stub
		return null;
	}

}
