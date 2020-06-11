package ma.pfe.projet.test;


import ma.pfe.projet.entity.Bus;

import ma.pfe.projet.entity.Destination;
import ma.pfe.projet.metier.IMetier;
import ma.pfe.projet.metier.MetierBus;



public class Test {

	public static void main(String[] args) {

		
		
		IMetier<Bus> metier =new MetierBus();
		// create a Bus
		Bus b = new Bus(79,"Y-339", "Bus A", "Class A");
		
		// add some destination
		
		b.addDestination(new Destination(22, "available", "3Y",45 ,82,  "classY"));
		
		System.out.println("Saving the Bus");
		System.out.println(b);
		System.out.println(b.getDestinations());
		
		metier.create(b);
		//List<Bus> allBus = metier.findAll();

	/*for (Client c : metier.findAll())
			System.out.println(c.getName()); */
		
			/*	Client u = new Client(8,"bahae", "bahae@hj", "9879879", "yyy", "dersa tetouan");
		dao.save(u); 	*/
		System.out.println("Done!");

	}

}
