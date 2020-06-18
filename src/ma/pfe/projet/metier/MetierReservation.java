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
	public boolean create(Reservation o) {
		
		return daoReservation.save(o);
	}

	@Override
	public boolean update(Reservation o) {
		return daoReservation.update(o);
	}

	@Override
	public boolean delete(Reservation o) {
		return daoReservation.delete(o);
	}

	@Override
	public Reservation findById(int id) {
		return daoReservation.findById(id);
	}

	@Override
	public List<Reservation> findAll() {
		return daoReservation.findAll();
	}

	@Override
	public List<Reservation> searchByType(String famille) {
		// TODO Auto-generated method stub
		return null;
	}

}
