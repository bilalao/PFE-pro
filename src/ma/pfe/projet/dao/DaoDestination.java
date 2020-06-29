package ma.pfe.projet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import ma.pfe.projet.entity.Destination;

@EnableTransactionManagement
@Transactional
@Repository("daoDestination")
public class DaoDestination implements IDAO<Destination> ,InterfaceDestDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean save(Destination o) {
		try {

			sessionFactory.getCurrentSession().save(o);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Destination o) {

		try {
			sessionFactory.getCurrentSession().update(o);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Destination o) {
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
	public List<Destination> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Destination").getResultList();
	}

	@Override
	public Destination findById(int id) {
		System.out.println("Destination id:" + id);
		return sessionFactory.getCurrentSession().get(Destination.class, id);
	}
	@Override
	public List<Destination> findByDestFrom(String destFrom) {
		System.out.println("Destination id:" + destFrom);
		StringBuilder reuest = new StringBuilder();
		reuest.append("from Destination where station_from = :destFrom");
		
		return sessionFactory.getCurrentSession().createQuery(reuest.toString())
				.setParameter("destFrom", destFrom)
				.getResultList();
	}
	@Override
	public List<Destination> findByDestFromAndDestTo(String destFrom, String destTo) {
		System.out.println("Destination id:" + destFrom + " - " +  destTo);
		StringBuilder reuest = new StringBuilder();
		reuest.append("from Destination where station_from = :destFrom");
		reuest.append(" and station_to = :destTo");
		return sessionFactory.getCurrentSession().createQuery(reuest.toString())
				.setParameter("destFrom", destFrom)
				.setParameter("destTo", destTo)
				.getResultList();
	}
	
	@Override
	public List<Destination> findByDestFromAndDestToAndDate(String destFrom, String destTo,int date) {
		System.out.println("Destination id:" + destFrom + " - " +  destTo);
		StringBuilder reuest = new StringBuilder();
		reuest.append("from Destination where station_from = :destFrom");
		reuest.append(" and station_to = :destTo  and time = :date ");
		return sessionFactory.getCurrentSession().createQuery(reuest.toString())
				.setParameter("destFrom", destFrom)
				.setParameter("destTo", destTo)
				.setParameter("date", date)
				.getResultList();
		
		
				
		
	}
}
