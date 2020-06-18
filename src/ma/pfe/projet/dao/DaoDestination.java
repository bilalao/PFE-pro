package ma.pfe.projet.dao;

import java.util.List;

import javax.print.attribute.standard.Destination;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Transactional
@Repository("daoDestination")

public class DaoDestination implements IDAO<Destination> {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean save(Destination o) {
		try {
			sessionFactory.getCurrentSession().save(o);
			System.out.println("Destination is created!");
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Destination o) {

		try {
			sessionFactory.getCurrentSession().update(o);

			System.out.println("Done!");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Destination o) {
		try {

			sessionFactory.getCurrentSession().delete(o);
			System.out.println("Destination is deleted");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Destination> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Destination").getResultList();
	}

	@Override
	public Destination findById(int id) {
		System.out.println("Destination id:" + id);
		return sessionFactory.getCurrentSession().get(Destination.class, id);
	}

}
