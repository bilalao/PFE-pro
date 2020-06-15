package ma.pfe.projet.test;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Bus;


import ma.pfe.projet.metier.IMetier;
import ma.pfe.projet.metier.MetierBus;



public class Test {

	public static void main(String[] args) {

		
		IMetier<Bus> metier = new MetierBus();
		
		
	    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			IDAO dao = (IDAO)ctx.getBean("daoBus");
			
	 		System.out.println(dao.findAll().size());
		

		System.out.println("Done!");

	}

}
