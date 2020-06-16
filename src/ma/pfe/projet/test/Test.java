package ma.pfe.projet.test;


//import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.pfe.projet.dao.DaoBus;
import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Bus;


public class Test {

	
	public static void main(String[] args) {
		IDAO<Bus> dao= new DaoBus();
		// create a Bus
				Bus b = new Bus(790,"Y-349", "Bus B", "Class C");
				//System.out.println("Saving the Bus");
				System.out.println(b);

				dao.save(b);
		

		//System.out.println("Done!");
		
		

	}

}
