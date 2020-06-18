package ma.pfe.projet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import ma.pfe.projet.entity.Client;
@EnableTransactionManagement
@Transactional
@Repository("daoClient")
public class DaoClient implements IDAO<Client> {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean save(Client o) {
		try {	
			sessionFactory.getCurrentSession().save(o);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean update(Client o) {
		try {	
			sessionFactory.getCurrentSession().update(o);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Client o) {
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
	public List<Client> findAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Client").getResultList();
	}

	@Override
	public Client findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
