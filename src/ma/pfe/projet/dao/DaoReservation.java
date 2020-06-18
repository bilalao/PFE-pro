package ma.pfe.projet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import ma.pfe.projet.entity.Reservation;


@EnableTransactionManagement
@Transactional
@Repository("daoReservation")
public class DaoReservation implements IDAO <Reservation> {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean save(Reservation o) {
		
		try {	
			sessionFactory.getCurrentSession().save(o);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Reservation o) {
		
		try {	
			sessionFactory.getCurrentSession().update(o);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Reservation o) {
		
		try {	
			sessionFactory.getCurrentSession().delete(o);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean validate(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reservation> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Reservation").getResultList();
	}

	@Override
	public Reservation findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
