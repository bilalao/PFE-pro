package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Reservation;
@Service
public class MetierReservation implements IMetier<Reservation> {
	@Autowired
	IDAO<Reservation> daoreservation;
	
	@Override
	public boolean create(Reservation o) {
		
		return daoreservation.save(o);
	}

	@Override
	public boolean update(Reservation o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Reservation o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> searchByType(String famille) {
		// TODO Auto-generated method stub
		return null;
	}

}
