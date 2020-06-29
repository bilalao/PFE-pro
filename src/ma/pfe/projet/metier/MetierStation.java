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

		return daoStation.save(o);
	}

	@Override
	public boolean update(Station o) {

		return daoStation.update(o);
	}

	@Override
	public boolean delete(Station o) {

		return daoStation.delete(o);
	}

	@Override
	public List<Station> findAll() {

		return daoStation.findAll();
	}

	@Override
	public boolean validate(String userName, String password) {

		return false;
	}

	@Override
	public Station findById(int id) {

		return daoStation.findById(id);
	}

}
