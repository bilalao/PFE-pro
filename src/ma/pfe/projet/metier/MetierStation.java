package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Station;

@Service
public class MetierStation implements IMetier<Station> {
	
	@Autowired
IDAO<Station> daoStation;
	
	@Override
	public boolean save(Station o) {
		// TODO Auto-generated method stub
		return daoStation.save(o);
	}

	@Override
	public boolean update(Station o) {
		// TODO Auto-generated method stub
		return daoStation.update(o);
	}

	@Override
	public boolean delete(Station o) {
		// TODO Auto-generated method stub
		return daoStation.delete(o);
	}

	
	@Override
	public List<Station> findAll() {
		// TODO Auto-generated method stub
		return daoStation.findAll();
	}

	@Override
	public boolean validate(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Station findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
