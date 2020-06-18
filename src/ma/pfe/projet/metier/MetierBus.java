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
		// TODO Auto-generated method stub
		return daoBus.save(o);
	}

	@Override
	public boolean update(Bus o) {
		// TODO Auto-generated method stub
		return daoBus.update(o);
	}

	@Override
	public boolean delete(Bus o) {
		// TODO Auto-generated method stub
		return daoBus.delete(o);
	}

	@Override
	public Bus findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bus> findAll() {
		// TODO Auto-generated method stub
		return daoBus.findAll();
	}

	@Override
	public boolean validate(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
