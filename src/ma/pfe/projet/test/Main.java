package ma.pfe.projet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ma.pfe.projet.entity.Bus;
import ma.pfe.projet.metier.IMetier;

public class Main {

	public static void main(String[] args) {

		ApplicationContext springContext = new AnnotationConfigApplicationContext("ma.pfe.projet.dao",
				"ma.pfe.projet.metier");

		IMetier<Bus> metier = springContext.getBean(IMetier.class);
		System.out.println(metier.findAll());

	}

}
