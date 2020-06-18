package ma.pfe.projet.metier;

import java.util.List;

public interface IMetier <T> {

	boolean save(T o);
	boolean update(T o);
	boolean delete(T o);
	T findById(int id);
	List<T> findAll();
	List<T> searchByType(String famille);
}
