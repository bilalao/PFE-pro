package ma.pfe.projet.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Destination;

//import ma.pfe.projet.metier.IMetier;

public class Main {

	public static void main(String[] args) {


    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
    IDAO<Destination> metier = (IDAO<Destination>) ctx.getBean("daoDestination");
		// IMetier<Destination> metier = new MetierDestination();

		System.out.println(metier.findById(1));

	}

}
