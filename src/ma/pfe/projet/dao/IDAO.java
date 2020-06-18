package ma.pfe.projet.dao;

import java.util.List;



public interface IDAO<T> {
	boolean save(T o);

	boolean update(T o);

	boolean delete(T o);

	// String GetTableName();
	/*default void SetById(int id) {
	}; */

	//boolean validate(String userName, String password);

	List<T> findAll();

	T findById(int id);
}
