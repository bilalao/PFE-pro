package ma.pfe.projet.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.dao.InterfaceDestDao;
import ma.pfe.projet.entity.Destination;

@Service
public class MetierDestination implements IMetier<Destination>,InterfaceDestMetier {
	@Autowired
	IDAO<Destination> daoDestination;
	
	@Autowired
	InterfaceDestDao interfaceDestDao;
	
	
	@Override
	public boolean save(Destination o) {
		return daoDestination.save(o);
	}

	@Override
	public boolean update(Destination o) {
		return daoDestination.update(o);
	}

	@Override
	public boolean delete(Destination o) {
		return daoDestination.delete(o);
	}

	@Override
	public Destination findById(int id) {
		return daoDestination.findById(id);
	}

	@Override
	public List<Destination> findAll() {
		return daoDestination.findAll();
	}

	@Override
	public boolean validate(String userName, String password) {
		return false;
	}
	@Override
	 public List<Destination> findByDestFrom(String destFrom) {
		return interfaceDestDao.findByDestFrom(destFrom);
	}
	@Override
	 public List<Destination> findByDestFromAndDestTo(String destFrom, String destTo) {
		 return interfaceDestDao.findByDestFromAndDestTo(destFrom, destTo);
	 }

	@Override
	public List<Destination> findByDestFromAndDestToAndDate(String destFrom, String destTo, int date) {
		 return interfaceDestDao.findByDestFromAndDestToAndDate(destFrom, destTo,date);
		
	}
	
	

}
