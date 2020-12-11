package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		EntityManagerFactory nf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = nf.createEntityManager();
		
		Person p = em.find(Person.class, 1);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
	
		em.close();
		nf.close();
		System.out.print("Ok!");
	}

}
