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
		// TODO Auto-generated method stub
		return daoClient.save(o);
	}

	@Override
	public boolean update(Client o) {
		// TODO Auto-generated method stub
		return daoClient.update(o);
	}

	@Override
	public boolean delete(Client o) {
		// TODO Auto-generated method stub
		return daoClient.delete(o);
	}

	@Override
	public Client findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return daoClient.findAll();
	}

	@Override
	public boolean validate(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
