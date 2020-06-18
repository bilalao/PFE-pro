package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Reservation;

@Service
public class MetierReservation implements IMetier<Reservation> {
	
	@Autowired
	IDAO<Reservation> daoReservation;
	
	@Override
	public boolean save(Reservation o) {
		// TODO Auto-generated method stub
		return daoReservation.save(o);
	}

	@Override
	public boolean update(Reservation o) {
		// TODO Auto-generated method stub
		return daoReservation.update(o);
	}

	@Override
	public boolean delete(Reservation o) {
		// TODO Auto-generated method stub
		return daoReservation.delete(o);
	}

	@Override
	public Reservation findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return daoReservation.findAll();
	}

	@Override
	public boolean validate(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
