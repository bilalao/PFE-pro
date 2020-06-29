package ma.pfe.projet.metier;

import java.util.List;

import ma.pfe.projet.entity.Destination;

public interface InterfaceDestMetier {
	List<Destination> findByDestFromAndDestTo(String destFrom, String destTo);

	List<Destination> findByDestFrom(String destFrom);
	
	List<Destination>  findByDestFromAndDestToAndDate(String destFrom, String destTo,int date);

}
