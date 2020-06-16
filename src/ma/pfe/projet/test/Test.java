package ma.pfe.projet.test;




//import org.springframework.context.support.ClassPathXmlApplicationContext;



import ma.pfe.projet.entity.Bus;
import ma.pfe.projet.metier.IMetier;
import ma.pfe.projet.metier.MetierBus;



public class Test {

	
	public static void main(String[] args) {
	
		IMetier<Bus> metier= new MetierBus();
		// create a Bus
				Bus b = new Bus(790,"Y-349", "Bus B", "Class C");
				System.out.println("Saving the Bus");
				System.out.println(b);

				metier.create(b);
		

		System.out.println("Done!");
		
		

	}

}
