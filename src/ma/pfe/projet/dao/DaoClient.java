package ma.pfe.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import ma.pfe.projet.entity.Client;
import ma.pfe.projet.util.HibernateUtils;

@Repository
@Transactional
@EnableTransactionManagement
public class DaoClient implements IDAO<Client> {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean save(Client o) {
		try {
			sessionFactory.getCurrentSession().save(o);
			System.out.println("client is created!");
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean validate(String email, String password) {

		Transaction transaction = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			String em = (String) session.createQuery("SELECT U.email FROM User U WHERE U.email=:n")
					.setParameter("n", email).uniqueResult();
			if (em != null) {
				String q = (String) session.createQuery("SELECT U.password FROM User U WHERE U.email=:p")
						.setParameter("p", em).uniqueResult();
				if (q.equals(password)) {
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}

		}

		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Client o) {

		try {
			sessionFactory.getCurrentSession().update(o);

			System.out.println("Done!");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Client o) {

		try {

			sessionFactory.getCurrentSession().delete(o);
			System.out.println("client is deleted");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Client> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Client").getResultList();
	}

	@Override
	public Client findById(int id) {
		System.out.println("Client id:" + id);
		return sessionFactory.getCurrentSession().get(Client.class, id);
	}

}
