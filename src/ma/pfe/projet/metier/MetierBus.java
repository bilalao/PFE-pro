package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Bus;

@Service
public class MetierBus implements IMetier<Bus> {

	@Autowired
	IDAO<Bus> daoBus;

	@Override
	public boolean save(Bus o) {

		return daoBus.save(o);
	}

	@Override
	public boolean update(Bus o) {

		return daoBus.update(o);
	}

	@Override
	public boolean delete(Bus o) {

		return daoBus.delete(o);
	}

	@Override
	public Bus findById(int id) {

		return daoBus.findById(id);
	}

	@Override
	public List<Bus> findAll() {

		return daoBus.findAll();
	}

	@Override
	public boolean validate(String userName, String password) {
		return false;
	}

}
