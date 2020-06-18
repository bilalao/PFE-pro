package ma.pfe.projet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import ma.pfe.projet.entity.Station;

@EnableTransactionManagement
@Transactional
@Repository("daoStation")
public class DaoStation implements IDAO<Station> {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean save(Station o) {
		
		try {	
			sessionFactory.getCurrentSession().save(o);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Station o) {
		try {	
			sessionFactory.getCurrentSession().update(o);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Station o) {
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
	public List<Station> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Station").getResultList();
	}

	@Override
	public Station findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
