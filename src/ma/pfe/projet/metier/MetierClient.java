package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pfe.projet.dao.IDAO;

import ma.pfe.projet.entity.Client;

@Service
public class MetierClient implements IMetier<Client> {

	@Autowired
	IDAO<Client> daoClient;

	@Override
	public boolean save(Client o) {

		return daoClient.save(o);
	}

	@Override
	public boolean update(Client o) {

		return daoClient.update(o);
	}

	@Override
	public boolean delete(Client o) {

		return daoClient.delete(o);
	}

	@Override
	public Client findById(int id) {

		return null;
	}

	@Override
	public List<Client> findAll() {

		return daoClient.findAll();
	}

	@Override
	public boolean validate(String userName, String password) {

		return false;
	}

}
